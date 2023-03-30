package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.JdbcUtils;
import org.example.domain.Organizator;
import org.example.domain.Participant;
import org.example.domain.cm3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrganizatorDbRepository implements Repository<Integer, Organizator> {

    private JdbcUtils dbUtils;



    private static final Logger logger= LogManager.getLogger();

    public OrganizatorDbRepository(Properties props) {
        logger.info("Initializing OrganizatorDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public void add(Organizator elem) {
        logger.traceEntry("saving organizator {}", elem);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("insert into organizator (username, password) values (?, ?)")) {
            preparedStatement.setString(1, elem.getUsername());
            preparedStatement.setString(2, elem.getPassword());
            int result = preparedStatement.executeUpdate();
            logger.trace("Saved {} instances", result);
        }
        catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }
    }

    @Override
    public void update(Integer integer, Organizator elem) {
        logger.traceEntry("updating taks {}", integer);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("UPDATE organizator SET username=?, password=? WHERE organizator.id=?")){

            preparedStatement.setString(1, elem.getUsername());
            preparedStatement.setString(2, elem.getPassword());
            preparedStatement.setInt(3, elem.getID());
            int result = preparedStatement.executeUpdate();
            logger.trace("Updated {} instances ", result);
        } catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }
        logger.traceExit();
    }

    public Organizator findOne(Organizator elem){
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from organizator where organizator.username=? and organizator.password=?")){
            preparedStatement.setString(1, elem.getUsername());
            preparedStatement.setString(2, elem.getPassword());
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String username = result.getString("username");
                    String password = result.getString("password");
                    Organizator organizator = new Organizator(username, password);
                    organizator.setID(id);
                    return organizator;
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(null);
            return null;
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }

        return null;
    }

    @Override
    public List<Organizator> findAll() {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Organizator> organizatori = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from organizator")){
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String username = result.getString("username");
                    String password = result.getString("password");
                    Organizator organizator = new Organizator(username, password);
                    organizator.setID(id);
                    organizatori.add(organizator);
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(organizatori);
            return organizatori;
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }

        return organizatori;
    }
}
