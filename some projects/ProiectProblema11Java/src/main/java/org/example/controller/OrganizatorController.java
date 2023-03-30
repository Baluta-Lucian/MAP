package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.domain.Cursa;
import org.example.domain.Participant;
import org.example.domain.TableParticipantHelper;
import org.example.domain.cm3;
import org.example.service.ServiceOrganizator;
import org.example.service.ServiceParticipant;

import java.util.List;

public class OrganizatorController {

    @FXML
    private TableColumn<Cursa, String> cm3CursaColumn;



    @FXML
    private TableView<Cursa> curseTableView;

    @FXML
    private TableColumn<Cursa, Integer> participantiColumn;

    ObservableList<Cursa> curseList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<TableParticipantHelper, String> capacitateColumn;

    @FXML
    private TableColumn<TableParticipantHelper, String> numeColumn;


    @FXML
    private TableView<TableParticipantHelper> teamTableView;

    ObservableList<TableParticipantHelper> teamList = FXCollections.observableArrayList();
    @FXML
    private Button searchTeamBtn;

    @FXML
    private TextField searchTeamTextField;

    @FXML
    private TextField echipaInscriereTextField;


    @FXML
    private ComboBox<String> capacitateComboBox;

    ObservableList<String> optionsComboBox = FXCollections.observableArrayList(
            "125",
            "150",
            "250",
            "450",
            "600",
            "650",
            "780",
            "1000",
            "1350"
    );
    @FXML
    private TextField numeInscriereTextField;

    @FXML
    private Button inscriereBtn;




    private ServiceOrganizator serviceOrganizator;
    private ServiceParticipant serviceParticipant;

    public void setService(ServiceOrganizator serviceOrganizator, ServiceParticipant serviceParticipant){
        this.serviceOrganizator = serviceOrganizator;
        this.serviceParticipant = serviceParticipant;
        initModel();
    }

    private void setCurseTableView(){
        participantiColumn.setCellValueFactory(new PropertyValueFactory<Cursa, Integer>("numarParticipanti"));
        cm3CursaColumn.setCellValueFactory(new PropertyValueFactory<Cursa, String>("capacitate"));

        curseTableView.setItems(curseList);
    }

    private void setTeamTableView(){
        numeColumn.setCellValueFactory(new PropertyValueFactory<TableParticipantHelper, String>("nume"));
        capacitateColumn.setCellValueFactory(new PropertyValueFactory<TableParticipantHelper, String>("capacitate"));

        teamTableView.setItems(teamList);
    }

    private void initModel(){
        List<Cursa> curse = serviceParticipant.getCurse();
        System.out.println("Numar curse initiale: " + curse.size());

        curseList.setAll(curse);

        setCurseTableView();

        searchTeamBtn.setOnAction(this::onSearchButtonPressed);
        inscriereBtn.setOnAction(this::onInscriereButtonPressed);
        capacitateComboBox.setItems(optionsComboBox);
    }

    @FXML
    void onInscriereButtonPressed(ActionEvent actionEvent){

        if(!capacitateComboBox.getSelectionModel().getSelectedItem().equals("")) {
            cm3 capacitate = cm3.valueOfLabel(capacitateComboBox.getSelectionModel().getSelectedItem());
            if(!numeInscriereTextField.getText().equals("")){
                String nume = numeInscriereTextField.getText();
                String echipa = echipaInscriereTextField.getText();
                serviceParticipant.addParticipant(nume, echipa, capacitate);

                echipaInscriereTextField.clear();
                numeInscriereTextField.clear();

                initModel();
            }
        }
        else{
            System.out.println("You must add cm3 and name!!!");
        }

    }



    @FXML
    void onSearchButtonPressed(ActionEvent actionEvent){
        if(searchTeamTextField.getText().equals("")){
            System.out.println("No team provided");

            teamList.clear();
            setTeamTableView();
        }
        else{
            String team = searchTeamTextField.getText();
            List<TableParticipantHelper> teamParticipanti = serviceParticipant.findParticipantiByTeam(team);

            teamList.setAll(teamParticipanti);

            searchTeamTextField.clear();

            setTeamTableView();
        }
    }

}
