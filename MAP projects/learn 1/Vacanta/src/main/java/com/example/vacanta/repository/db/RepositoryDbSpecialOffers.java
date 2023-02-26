package com.example.vacanta.repository.db;

import com.example.vacanta.domain.Hotel;
import com.example.vacanta.domain.Locatie;
import com.example.vacanta.domain.SpecialOffer;
import com.example.vacanta.domain.Type;
import com.example.vacanta.repository.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDbSpecialOffers implements Repository<Double, SpecialOffer> {
    private String url;

    private String username;

    private String password;

    public RepositoryDbSpecialOffers(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public SpecialOffer findOne(Double aDouble) {
        return null;
    }

    @Override
    public List<SpecialOffer> findAll() {

        List<SpecialOffer> specialOffers = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from specialoffers");
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                double specialOfferId = resultSet.getDouble("specialofferid");
                double hotelId = resultSet.getDouble("hotelid");
                LocalDate startDate = resultSet.getDate("startdate").toLocalDate();
                LocalDate endDate = resultSet.getDate("enddate").toLocalDate();
                int percents = resultSet.getInt("percents");

                SpecialOffer specialOffer = new SpecialOffer(specialOfferId, hotelId, startDate, endDate, percents);
                specialOffers.add(specialOffer);
            }
            return specialOffers;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return specialOffers;

    }

    @Override
    public SpecialOffer delete(Double aDouble) {
        return null;
    }

    @Override
    public SpecialOffer update(SpecialOffer entity) {
        return null;
    }
}
