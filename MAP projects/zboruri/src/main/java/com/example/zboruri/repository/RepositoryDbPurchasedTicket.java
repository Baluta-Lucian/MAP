package com.example.zboruri.repository;

import com.example.zboruri.domain.Client;
import com.example.zboruri.domain.Flight;
import com.example.zboruri.domain.PurchasedTicket;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.valueOf;

public class RepositoryDbPurchasedTicket {

    private String url;
    private String username;
    private String password;

    public RepositoryDbPurchasedTicket(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public PurchasedTicket save(PurchasedTicket entity) {
        if(entity == null)
            return null;

        String sql = "INSERT INTO purchasedticket values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, entity.getId().intValue());
            ps.setString(2, entity.getFrom());
            ps.setString(3, entity.getTo());
            ps.setDate(4, Date.valueOf(entity.getDepartureTime().toLocalDate()));
            ps.setDate(5, Date.valueOf(entity.getLandingTime().toLocalDate()));
            ps.setInt(6, entity.getSeats());
            ps.setInt(7, entity.getAvailableTickets());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(PurchasedTicket purchasedTicket) {
        if (findOne(purchasedTicket.getId()) != null) {

            String sql = "UPDATE purchasedticket SET availabletickets = ? WHERE flightid = ?";
            try (Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, purchasedTicket.getAvailableTickets());
                statement.setInt(2, purchasedTicket.getId().intValue());

                statement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public PurchasedTicket findOne(Long idFlight) {
        if (idFlight == null)
            return null;
        String sql = "SELECT * FROM purchasedticket where purchasedticket.flightid = ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, idFlight.intValue());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Long id = valueOf(resultSet.getInt("flightid"));
                String from = resultSet.getString("from");
                String to = resultSet.getString("to");
                LocalDateTime departureTime = resultSet.getDate("departuretime").toLocalDate().atStartOfDay();
                LocalDateTime landingTime = resultSet.getDate("landingtime").toLocalDate().atStartOfDay();
                int seats = resultSet.getInt("seats");
                int availableTickets = resultSet.getInt("availabletickets");


                Flight zbor = new Flight(id, from, to, departureTime, landingTime, seats);
                PurchasedTicket purchasedTicket = new PurchasedTicket(zbor, availableTickets);
                return purchasedTicket;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<PurchasedTicket> findAll(){
        PurchasedTicket purchasedTicket;
        List<PurchasedTicket> tickets = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from purchasedticket");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = valueOf(resultSet.getInt("flightid"));
                String from = resultSet.getString("from");
                String to = resultSet.getString("to");
                LocalDateTime departureTime = resultSet.getDate("departuretime").toLocalDate().atStartOfDay();
                LocalDateTime landingTime = resultSet.getDate("landingtime").toLocalDate().atStartOfDay();
                int seats = resultSet.getInt("seats");
                int availableTickets = resultSet.getInt("availabletickets");

                Flight zbor = new Flight(id, from, to, departureTime, landingTime, seats);
                purchasedTicket = new PurchasedTicket(zbor, availableTickets);
                tickets.add(purchasedTicket);
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

}
