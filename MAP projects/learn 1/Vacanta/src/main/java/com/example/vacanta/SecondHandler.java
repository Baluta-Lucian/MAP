package com.example.vacanta;

import com.example.vacanta.domain.Hotel;
import com.example.vacanta.domain.Locatie;
import com.example.vacanta.domain.SpecialOffer;
import com.example.vacanta.repository.Repository;
import com.example.vacanta.repository.db.RepositoryDbHoteluri;
import com.example.vacanta.repository.db.RepositoryDbLocatii;
import com.example.vacanta.repository.db.RepositoryDbSpecialOffers;
import com.example.vacanta.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class SecondHandler implements Initializable{



    //Modalitate de a da pass la obiect din window catre controller
//    @FXML
//    protected void onLabelStart(ActionEvent event){
//        Node node = (Node) event.getSource();
//        Stage thisStage = (Stage) node.getScene().getWindow();
//        Hotel thisHotel = (Hotel) thisStage.getUserData();
//
//
//
//    }

    private String url = "jdbc:postgresql://localhost:5432/ProjectHotel";
    private String username = "postgres";
    private String password = "CripiFace2";
    private Repository<Double, Locatie> repoLoc = new RepositoryDbLocatii(url, username, password);
    private Repository<Double, Hotel> repoHot = new RepositoryDbHoteluri(url, username, password);

    private  Repository <Double, SpecialOffer> repoSpeOff = new RepositoryDbSpecialOffers(url, username, password);

    private Service service = new Service((RepositoryDbLocatii) repoLoc, (RepositoryDbHoteluri) repoHot, (RepositoryDbSpecialOffers) repoSpeOff);


    @FXML
    private TableView<SpecialOffer> myTableView;

    @FXML
    private TableColumn<SpecialOffer, LocalDate> endDateColumn;

    @FXML
    private TableColumn<SpecialOffer, Double> hotelIdColumn;

    @FXML
    private DatePicker myDatePicker;

    @FXML
    private TableColumn<SpecialOffer, Integer> percentsColumn;

    //@FXML
    //private TableColumn<SpecialOffer, Double> specialOfferIdColumn;

    @FXML
    private TableColumn<SpecialOffer, LocalDate> startDateColumn;



    @FXML
    protected void getDate(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        Hotel thisHotel = (Hotel) thisStage.getUserData();

        LocalDate date = myDatePicker.getValue();

        System.out.println(thisHotel);

        ObservableList<SpecialOffer> tableItems = FXCollections.observableArrayList(service.searchOfferByHotelAndDate(thisHotel, date));

        //initializam coloanele
        //specialOfferIdColumn.setCellValueFactory(new PropertyValueFactory<SpecialOffer, Double>("specialOfferId"));
        hotelIdColumn.setCellValueFactory(new PropertyValueFactory<SpecialOffer, Double>("hotelId"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<SpecialOffer, LocalDate>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<SpecialOffer, LocalDate>("endDate"));
        percentsColumn.setCellValueFactory(new PropertyValueFactory<SpecialOffer, Integer>("percents"));

        myTableView.setItems(tableItems);





    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
