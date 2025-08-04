package org.example.dao;

import lombok.SneakyThrows;
import org.example.entity.User;
import org.example.util.ConnectionManager;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();

    private final String SAVE = """
            INSERT INTO users(name, birthday, email, password, role, gender) 
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    private UserDao(){

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @SneakyThrows
    @Override
    public User save(User user) {
        try(var connection = ConnectionManager.get();
            var prepareStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)){

            prepareStatement.setObject(1, user.getName());
            prepareStatement.setObject(2, user.getBirthday());
            prepareStatement.setObject(3, user.getEmail());
            prepareStatement.setObject(4, user.getPassword());
            prepareStatement.setObject(5, user.getRole().name());
            prepareStatement.setObject(6, user.getGender().name());

            prepareStatement.executeUpdate();

            var keys = prepareStatement.getGeneratedKeys();
            keys.next();
            user.setId(keys.getInt("id"));

            return user;
        }
    }

    public static UserDao getInstance(){
        return INSTANCE;
    }
}
