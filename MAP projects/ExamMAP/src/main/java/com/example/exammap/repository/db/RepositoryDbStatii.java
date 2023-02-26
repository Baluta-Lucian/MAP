package com.example.exammap.repository.db;

import com.example.exammap.domain.City;
import com.example.exammap.domain.TrainStation;
import com.example.exammap.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDbStatii {
    private String url;
    private String username;
    private String password;

    public RepositoryDbStatii(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }



    public TrainStation findOne(String s) {
        return null;
    }


    public List<TrainStation> findAll() {
        List<TrainStation> statii = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from trainstations");
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                String trainId = resultSet.getString("trainid");
                String departureCityId = resultSet.getString("departurecityid");
                String destinationCityId = resultSet.getString("destinationcityid");
                TrainStation statie = new TrainStation(trainId, departureCityId, destinationCityId);
                statii.add(statie);
            }
            return statii;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return statii;
    }


    public TrainStation delete(String s) {
        return null;
    }


    public TrainStation update(TrainStation entity) {
        return null;
    }
}
