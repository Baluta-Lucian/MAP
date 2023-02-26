package com.example.exammap.repository.db;

import com.example.exammap.domain.City;
import com.example.exammap.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDbCities implements Repository<String, City> {

    private String url;
    private String username;
    private String password;

    public RepositoryDbCities(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public City findOne(String s) {
        return null;
    }

    @Override
    public List<City> findAll() {
        List<City> orase = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from orase");
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                City oras = new City(id, name);
                orase.add(oras);
            }
            return orase;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return orase;
    }

    @Override
    public City delete(String s) {
        return null;
    }

    @Override
    public City update(City entity) {
        return null;
    }
}
