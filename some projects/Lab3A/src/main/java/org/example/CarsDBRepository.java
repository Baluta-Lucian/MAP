package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarsDBRepository implements CarRepository{

    private JdbcUtils dbUtils;



    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }


    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
 	//to do
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from masini where masini.manufacturer=?")){
            preparedStatement.setString(1, manufacturerN);
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(cars);
            return cars;
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }

        return cars;
    }



    @Override
    public List<Car> findBetweenYears(int min, int max) {
	//to do
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from masini where masini.year>=? AND masini.year<=?")){
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(cars);
            return cars;
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }

        return cars;
    }

    @Override
    public void add(Car elem) {
        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement = con.prepareStatement("insert into masini (manufacturer, model, year) values (?, ?, ?)")) {
            preparedStatement.setString(1, elem.getManufacturer());
            preparedStatement.setString(2, elem.getModel());
            preparedStatement.setInt(3, elem.getYear());
            int result = preparedStatement.executeUpdate();
            logger.trace("Saved {} instances", result);
        }
        catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB "+ex);
        }
    }

    @Override
    public void update(Integer integer, Car elem) {
      logger.traceEntry("updating taks {}", integer);
      Connection con = dbUtils.getConnection();
      try(PreparedStatement preparedStatement = con.prepareStatement("UPDATE masini SET masini.manufacturer=?, masini.model=?, masini.year=? WHERE masini.id=?")){

          preparedStatement.setString(1, elem.getManufacturer());
          preparedStatement.setString(2, elem.getModel());
          preparedStatement.setInt(3, elem.getYear());
          preparedStatement.setInt(4, elem.getId());
          int result = preparedStatement.executeUpdate();
          logger.trace("Updated {} instances ", result);
      } catch (SQLException ex){
          logger.error(ex);
          System.err.println("Error DB "+ex);
      }
      logger.traceExit();
    }

    @Override
    public Iterable<Car> findAll() {
         //to do
	    logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preparedStatement = con.prepareStatement("select * from masini")){
            try(ResultSet result = preparedStatement.executeQuery()){
                while(result.next()){
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            } catch (SQLException ex){
                logger.error(ex);
                System.err.println("Error DB "+ex);
            }
            logger.traceExit(cars);
            return cars;
        } catch (SQLException ex) {
                logger.error(ex);
                System.err.println("Error DB "+ex);
        }

        return cars;
    }

}
