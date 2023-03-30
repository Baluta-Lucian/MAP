//package org.example.repository;
//
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.example.JdbcUtils;
//import org.example.domain.Cursa;
//import org.example.domain.Participant;
//import org.example.domain.cm3;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//public class CursaDbRepository implements Repository<Integer, Cursa>{
//
//    private JdbcUtils dbUtils;
//
//
//
//    private static final Logger logger = LogManager.getLogger();
//
//    public CursaDbRepository(Properties props) {
//        logger.info("Initializing CursaDBRepository with properties: {} ",props);
//        dbUtils=new JdbcUtils(props);
//    }
//
//
//    @Override
//    public void add(Cursa elem) {
//
//    }
//
//    @Override
//    public void update(Integer integer, Cursa elem) {
//
//    }
//
//    @Override
//    public List<Cursa> findAll() {
//        logger.traceEntry();
//        Connection con = dbUtils.getConnection();
//        List<Cursa> curse = new ArrayList<>();
//        try(PreparedStatement preparedStatement = con.prepareStatement("select * from cursa")){
//            try(ResultSet result = preparedStatement.executeQuery()){
//                while(result.next()){
//                    int id = result.getInt("id");
//                    String nume = result.getString("nume");
//                    cm3 capacitate = cm3.valueOf(result.getString("capacitate"));
//                    String team= result.getString("team");
//                    if(team == null) {
//                        Participant participant = new Participant(nume, capacitate);
//                        participant.setID(id);
//                        participanti.add(participant);
//                    } else{
//                        Participant participant = new Participant(nume, capacitate, team);
//                        participant.setID(id);
//                        participanti.add(participant);
//                    }
//                }
//            } catch (SQLException ex){
//                logger.error(ex);
//                System.err.println("Error DB "+ex);
//            }
//            logger.traceExit(participanti);
//            return participanti;
//        } catch (SQLException ex) {
//            logger.error(ex);
//            System.err.println("Error DB "+ex);
//        }
//
//        return participanti;
//    }
//}
