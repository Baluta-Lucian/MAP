package com.example.vacanta.repository.db;

import com.example.vacanta.domain.Hotel;
import com.example.vacanta.domain.Locatie;
import com.example.vacanta.domain.Type;
import com.example.vacanta.repository.Repository;

import java.util.*;

import java.sql.*;

public class RepositoryDbLocatii implements Repository<Double, Locatie> {

    private String url;

    private String username;

    private String password;

    public RepositoryDbLocatii(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }



    @Override
    public Locatie findOne(Double aDouble) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from locatii L where L.locationid=?")) {
            statement.setDouble(1, aDouble);
            try (
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Double locationId = resultSet.getDouble("locationid");
                    String locationName = resultSet.getString("locationame");

                    if (locationId == aDouble) {

                        return new Locatie(aDouble, locationName);
                    }

                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Locatie> findAll() {
        List<Locatie> locatii = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from locatii");
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                double locationId = resultSet.getDouble("locationid");
                String locationName = resultSet.getString("locationname");

                Locatie locatie = new Locatie(locationId, locationName);
                locatii.add(locatie);
            }
            return locatii;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return locatii;
    }

    @Override
    public Locatie delete(Double aDouble) {
        return null;
    }

    @Override
    public Locatie update(Locatie entity) {
        return null;
    }
}
