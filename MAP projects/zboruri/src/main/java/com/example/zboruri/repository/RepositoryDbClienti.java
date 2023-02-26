package com.example.zboruri.repository;

import com.example.zboruri.domain.Client;
import com.example.zboruri.domain.Flight;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.valueOf;

public class RepositoryDbClienti {

    private String url;
    private String username;
    private String password;

    public RepositoryDbClienti(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Client save(Client entity) {
        if(entity == null)
            return null;

        String sql = "insert into client (username, name) values (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getName());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Client> findAll() {
        Client client;
        List<Client> clienti = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from client");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");

                client = new Client(username, name);
                clienti.add(client);
            }
            return clienti;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienti;


    }

    public Client findOne(String userName) {
        if (userName == null)
            return null;
        String sql = "SELECT * FROM client where client.username = ?";
        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String usernameNeeded = resultSet.getString("username");
                String nameNeeded = resultSet.getString("name");

                Client client = new Client(usernameNeeded,nameNeeded);
                return client;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
