package org.example.mapper;

import org.example.dto.CreateUserDto;
import org.example.entity.Gender;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
