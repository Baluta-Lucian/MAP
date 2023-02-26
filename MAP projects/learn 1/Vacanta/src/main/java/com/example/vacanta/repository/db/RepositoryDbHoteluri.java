package com.example.vacanta.repository.db;

import com.example.vacanta.domain.Hotel;
import com.example.vacanta.domain.Type;
import com.example.vacanta.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositoryDbHoteluri implements Repository<Double, Hotel> {

    private String url;
    private String username;
    private String password;

    public RepositoryDbHoteluri(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Hotel findOne(Double aDouble) {
        return null;
    }

    @Override
    public List<Hotel> findAll(){

        List<Hotel> hoteluri = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("SELECT * from hoteluri");
        ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                double hotelId = resultSet.getDouble("hotelid");
                double locationId = resultSet.getDouble("locationid");
                String hotelName = resultSet.getString("hotelname");
                int noRooms = resultSet.getInt("norooms");
                double pricePerNight = resultSet.getDouble("pricepernight");
                Type type = Type.valueOf(resultSet.getString("type"));

                Hotel hotel = new Hotel(hotelId, locationId, hotelName, noRooms, pricePerNight, type);
                hoteluri.add(hotel);
            }
            return hoteluri;
        } catch (SQLException e){
            e.printStackTrace();
        }
            return hoteluri;

}

    @Override
    public Hotel delete(Double aDouble) {
        return null;
    }

    @Override
    public Hotel update(Hotel entity) {
        return null;
    }
}
