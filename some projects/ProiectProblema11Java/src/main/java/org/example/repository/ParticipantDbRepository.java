package org.example.repository;

import org.example.JdbcUtils;
import org.example.domain.Participant;
import org.example.domain.cm3;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import java.util.List;

public class ParticipantDbRepository implements ParticipantRepository{

    private JdbcUtils dbUtils;



    private static final Logger logger= LogManager.getLogger();

    public ParticipantDbRepository(Properties props) {
        logger.info("Initializing ParticipantDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }



    @Override
    public List<Participant> findByCapacitate(cm3 capacitate) {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Participant> participanti = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from participant where participant.capacitate=?")){
            preparedStatement.setString(1, capacitate.toString());
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    cm3 cap = cm3.valueOf(result.getString("capacitate"));
                    String team = result.getString("team");
                    if(team == null){
                        Participant participant = new Participant(nume, cap);
                        participant.setID(id);
                        participanti.add(participant);
                    }
                    else{
                        Participant participant = new Participant(nume, cap, team);
                        participant.setID(id);
                        participanti.add(participant);
                    }
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(participanti);
            return participanti;
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }

        return participanti;
    }

    @Override
    public List<Participant> findByTeam(String team) {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Participant> participanti = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from participant where participant.team=?")){
            preparedStatement.setString(1, team);
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    cm3 cap = cm3.valueOf(result.getString("capacitate"));
                    String team1 = result.getString("team");
                    if(team1 == null){
                        Participant participant = new Participant(nume, cap);
                        participant.setID(id);
                        participanti.add(participant);
                    }
                    else{
                        Participant participant = new Participant(nume, cap, team);
                        participant.setID(id);
                        participanti.add(participant);
                    }
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(participanti);
            return participanti;
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }

        return participanti;
    }

    @Override
    public void add(Participant elem) {
        logger.traceEntry("saving participant {}", elem);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("insert into participant (nume, capacitate, team) values (?, ?, ?)")) {
            preparedStatement.setString(1, elem.getNume());
            preparedStatement.setString(2, elem.getCapacitate());
            preparedStatement.setString(3, elem.getTeam());
            int result = preparedStatement.executeUpdate();
            logger.trace("Saved {} instances", result);
        }
        catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }
    }

    @Override
    public void update(Integer integer, Participant elem) {
        logger.traceEntry("updating taks {}", integer);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("UPDATE participant SET nume=?, capacitate=?, team=? WHERE participant.id=?")){

            preparedStatement.setString(1, elem.getNume());
            preparedStatement.setString(2, elem.getCapacitate());
            preparedStatement.setString(3, elem.getTeam());
            preparedStatement.setInt(4, elem.getID());
            int result = preparedStatement.executeUpdate();
            logger.trace("Updated {} instances ", result);
        } catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }
        logger.traceExit();
    }

    @Override
    public List<Participant> findAll() {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Participant> participanti = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from participant")){
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String nume = result.getString("nume");
                    cm3 capacitate = cm3.valueOf(result.getString("capacitate"));
                    String team= result.getString("team");
                    if(team == null) {
                        Participant participant = new Participant(nume, capacitate);
                        participant.setID(id);
                        participanti.add(participant);
                    } else{
                        Participant participant = new Participant(nume, capacitate, team);
                        participant.setID(id);
                        participanti.add(participant);
                    }
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(participanti);
            return participanti;
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }

        return participanti;
    }
}
