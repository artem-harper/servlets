package org.example.dao;

import org.example.entity.Ticket;
import org.example.entity.User;
import org.example.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket>{

    private final static TicketDao INSTANCE = new TicketDao();

    private final static String TICKET_BY_FLIGHT = """
            SELECT * 
            FROM ticket
            WHERE flight_id=?
            """;


    private TicketDao(){

    }

    public List<Ticket> getTicketsByFlightId(Long flightId) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(TICKET_BY_FLIGHT)) {

            prepareStatement.setObject(1, flightId);

            var resultSet = prepareStatement.executeQuery();

            List<Ticket> tickets = new ArrayList<>();

            while(resultSet.next()){
                tickets.add(buildTicket(resultSet));
            }

            return tickets;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Ticket buildTicket(ResultSet resultSet) {
        try {
            return new Ticket(resultSet.getObject("id", Long.class),
                    resultSet.getObject("passenger_no", String.class),
                    resultSet.getObject("passenger_name", String.class),
                    resultSet.getObject("flight_id", Long.class),
                    resultSet.getObject("seat_no", String.class),
                    resultSet.getObject("cost", BigDecimal.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static TicketDao getInstance(){
        return INSTANCE;
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public User save(User user) {
        return null;
    }
}
