package com.example.vacanta;

import com.example.vacanta.domain.Hotel;
import com.example.vacanta.domain.Locatie;
import com.example.vacanta.domain.SpecialOffer;
import com.example.vacanta.domain.Type;
import com.example.vacanta.repository.Repository;
import com.example.vacanta.repository.db.RepositoryDbHoteluri;
import com.example.vacanta.repository.db.RepositoryDbLocatii;
import com.example.vacanta.repository.db.RepositoryDbSpecialOffers;
import com.example.vacanta.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    /*
    *
    * @TODO Asta e facuta pentru 1), comboBox+TableView (initialize, setOnAction, declareColumnsTable, etc)
    *
    * */



    private String url = "jdbc:postgresql://localhost:5432/ProjectHotel";
    private String username = "postgres";
    private String password = "CripiFace2";
    private Repository<Double, Locatie> repoLoc = new RepositoryDbLocatii(url, username, password);
    private Repository<Double, Hotel> repoHot = new RepositoryDbHoteluri(url, username, password);

    private  Repository <Double, SpecialOffer> repoSpeOff = new RepositoryDbSpecialOffers(url, username, password);

    private Service service = new Service((RepositoryDbLocatii) repoLoc, (RepositoryDbHoteluri) repoHot, (RepositoryDbSpecialOffers) repoSpeOff);

    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox<Locatie> mainComboBox;
    ObservableList<Locatie> mainCombo = FXCollections.observableArrayList(service.getLocations());


    //table view
    @FXML
    private TableView<Hotel> myTableView;

    //columns
    @FXML
    private TableColumn<Hotel, String> hotelNameColumn;
    @FXML
    private TableColumn<Hotel, Integer> noRoomsColumn;
    @FXML
    private TableColumn<Hotel, Double> pricePerNightColumn;
    @FXML
    private TableColumn<Hotel, Type> typeColumn;
    //done columns

//    @FXML
//    protected void initialize(){
//        mainComboBox.setItems(mainCombo);
//
//        mainComboBox.setCellFactory(new Callback<ListView<Locatie>, ListCell<Locatie>>() {
//            @Override
//            public ListCell<Locatie> call(ListView<Locatie> param) {
//                return new ListCell<Locatie>(){
//                    @Override
//                    protected void updateItem(Locatie item, boolean empty){
//                        super.updateItem(item, empty);
//                        if(item == null || empty){
//                            setText(null);
//                        }
//                        else{
//                            setText(item.getLocationName());
//                        }
//                    }
//                };
//            }
//        });
//
//    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    public void getElemsForTable(ActionEvent event){

        Locatie locatie = mainComboBox.getSelectionModel().getSelectedItem();
        ObservableList<Hotel> tableItems= FXCollections.observableArrayList(service.searchHotelsInLocation(locatie));
        //initialize columns

        hotelNameColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("hotelName"));
        noRoomsColumn.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("noRooms"));
        pricePerNightColumn.setCellValueFactory(new PropertyValueFactory<Hotel, Double>("pricePerNight"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Hotel, Type>("type"));

        myTableView.setItems(tableItems);
    }


    //creating new window and getting information from table
    @FXML
    void openNewWindow(MouseEvent event) {

        Hotel hotelForNewWindow= myTableView.getSelectionModel().getSelectedItem();

        try{
            SecondWindow.display(hotelForNewWindow);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainComboBox.setItems(mainCombo);

//        mainComboBox.setCellFactory(new Callback<ListView<Locatie>, ListCell<Locatie>>() {
//            @Override
//            public ListCell<Locatie> call(ListView<Locatie> param) {
//                return new ListCell<Locatie>(){
//                    @Override
//                    protected void updateItem(Locatie item, boolean empty){
//                        super.updateItem(item, empty);
//                        if(item == null || empty){
//                            setText(null);
//                        }
//                        else{
//                            setText(item.getLocationName());
//                        }
//                    }
//                };
//            }
//        });

        mainComboBox.setOnAction(this::getElemsForTable);
        myTableView.setOnMouseClicked(this::openNewWindow);
    }
}