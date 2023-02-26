package com.example.exammap;

import com.example.exammap.domain.City;
import com.example.exammap.domain.TrainStation;
import com.example.exammap.repository.Repository;
import com.example.exammap.repository.db.RepositoryDbCities;
import com.example.exammap.repository.db.RepositoryDbStatii;
import com.example.exammap.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class NewWindowController implements Initializable {

    private String url = "jdbc:postgresql://localhost:5432/examdatabase";
    private String username = "postgres";
    private String password = "CripiFace2";

    Repository<String, City> repoOrase = new RepositoryDbCities(url, username, password);
    RepositoryDbStatii repoStatii = new RepositoryDbStatii(url, username, password);
    Service service = new Service((RepositoryDbCities) repoOrase, repoStatii);

    //trainView
    @FXML
    private TableView<TrainStation> myTableView;

    @FXML
    private TableColumn<TrainStation, String> trainId1Column;
    @FXML
    private TableColumn<TrainStation, String> trainId2Column;

    @FXML
    private TableColumn<TrainStation, String> city1Column;

    @FXML
    private TableColumn<TrainStation, String> city2Column;


    @FXML
    private CheckBox myCheckBoxButton;

    @FXML
    private ComboBox<City> myCombo1;

    ObservableList<City> myComboItems = FXCollections.observableArrayList(service.getCities());

    @FXML
    private ComboBox<City> myCombo2;



    @FXML
    private Button mySearchButton;

    @FXML
    protected void onButtonSearch(){
        if(myCheckBoxButton.isSelected()){
            City c1 = myCombo1.getSelectionModel().getSelectedItem();
            City c2 = myCombo2.getSelectionModel().getSelectedItem();

            ObservableList<TrainStation> tableItems = FXCollections.observableArrayList(service.routesForChecked(c1, c2));

            trainId1Column.setCellValueFactory(new PropertyValueFactory<TrainStation, String>("trainId"));
            city1Column.setCellValueFactory(new PropertyValueFactory<TrainStation, String>("departureCityId"));
            trainId2Column.setCellValueFactory(new PropertyValueFactory<TrainStation, String>("trainId"));
            city2Column.setCellValueFactory(new PropertyValueFactory<TrainStation, String>("destinationCityId"));

            myTableView.setItems(tableItems);

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myCombo1.setItems(myComboItems);
        myCombo2.setItems(myComboItems);
    }
}
