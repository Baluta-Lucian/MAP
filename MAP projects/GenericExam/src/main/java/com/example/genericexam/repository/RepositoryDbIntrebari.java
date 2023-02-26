package com.example.genericexam.repository;

import com.example.genericexam.domain.Intrebare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDbIntrebari {
    private String url;
    private String username;
    private String password;

    public RepositoryDbIntrebari(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public List<Intrebare> findAll() {
        Intrebare intrebare;
        List<Intrebare> intrebari = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from intrebare");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int nrIntrebare = resultSet.getInt("nrintrebare");
                String descriere = resultSet.getString("descriere");
                String v1 = resultSet.getString("v1");
                String v2 = resultSet.getString("v2");
                String v3 = resultSet.getString("v3");
                String raspunsCorect = resultSet.getString("raspunscorect");
                int punctaj = resultSet.getInt("punctaj");
                intrebare= new Intrebare(nrIntrebare, descriere, v1, v2, v3, raspunsCorect, punctaj);
                intrebari.add(intrebare);
            }
            return intrebari;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intrebari;


    }
}
