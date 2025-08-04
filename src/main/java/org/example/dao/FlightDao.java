package org.example.dao;

import org.example.entity.Flight;
import org.example.entity.FlightStatus;
import org.example.entity.User;
import org.example.util.ConnectionManager;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.ToLongBiFunction;

public class FlightDao implements Dao<Long, Flight> {

    private final static FlightDao INSTANCE = new FlightDao();

    private FlightDao(){
    }

    private final String FIND_ALL = """
                        SELECT id,
                            flight_no, 
                    departure_date, 
                    departure_airport_code, 
                    arrival_date,
                    arrival_airport_code,
                    aircraft_id,
                    status 
    FROM flight
""";

    @Override
    public List<Flight> findAll() {
        try(var connection = ConnectionManager.get();
            var prepareStatement = connection.prepareStatement(FIND_ALL)){

            List<Flight> flights = new ArrayList<>();

            var resultSet = prepareStatement.executeQuery();

            while (resultSet.next()){
                flights.add(buildFlight(resultSet));
            }

            return flights;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public User save(User user) {
        return null;
    }

    private Flight buildFlight(ResultSet resultSet) {
        try {
            return new Flight(
                    resultSet.getObject("id", Long.class),
                    resultSet.getObject("flight_no", String.class),
                    resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("departure_airport_code", String.class),
                    resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("arrival_airport_code", String.class),
                    resultSet.getObject("aircraft_id", Integer.class),
                    FlightStatus.valueOf(resultSet.getObject("status", String.class))
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static FlightDao getInstance(){
        return INSTANCE;
    }
}
