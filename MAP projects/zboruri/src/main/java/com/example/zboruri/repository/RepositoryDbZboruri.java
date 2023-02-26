package com.example.zboruri.repository;

import com.example.zboruri.domain.Flight;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.valueOf;

public class RepositoryDbZboruri {

    private String url;
    private String username;
    private String password;

    public RepositoryDbZboruri(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Flight> findAll(){
        Flight zbor;
        List<Flight> zboruri = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from flight");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = valueOf(resultSet.getInt("flightid"));
                String from = resultSet.getString("from");
                String to = resultSet.getString("to");
                LocalDateTime departureTime = resultSet.getDate("departuretime").toLocalDate().atStartOfDay();
                LocalDateTime landingTime = resultSet.getDate("landingtime").toLocalDate().atStartOfDay();
                int seats = resultSet.getInt("seats");

                zbor = new Flight(id, from, to, departureTime, landingTime, seats);
                zboruri.add(zbor);
            }
            return zboruri;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zboruri;
    }
}
