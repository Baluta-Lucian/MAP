package com.example.genericexam.controller;

import com.example.genericexam.domain.Intrebare;
import com.example.genericexam.domain.Raspuns;
import com.example.genericexam.service.Service;
import com.example.genericexam.service.ServiceProfesor;
import com.example.genericexam.service.ServiceStudent;
import com.example.genericexam.utils.events.IntrebareEvent;
import com.example.genericexam.utils.events.RaspunsEvent;
import com.example.genericexam.utils.observer.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfesorController implements Observer<RaspunsEvent> {

    ServiceStudent serviceStudent;
    ServiceProfesor serviceProfesor;

    String s1;
    String s2;
    String s3;

    int i = 1;

    @FXML
    private Button plaseazaIntrebareBtn;

    @FXML
    private TableColumn<Intrebare, String> testDescriereColumn;

    @FXML
    private TableColumn<Intrebare, Integer> testNrIntrebareColumn;

    @FXML
    private TableColumn<Intrebare, Integer> testPunctajColumn;

    @FXML
    private TableColumn<Intrebare, String> testRaspunsColumn;

    @FXML
    private TableView<Intrebare> testTableView;

    @FXML
    private Label punctajMaximLabel;

    @FXML
    private TableColumn<Intrebare, String> testV1Column;

    @FXML
    private TableColumn<Intrebare, String> testV2Column;

    @FXML
    private TableColumn<Intrebare, String> testV3Column;



    @FXML
    private TableColumn<Intrebare, String> descriereColumn;

    @FXML
    private TableColumn<Intrebare, Integer> nrIntrebareColumn;

    @FXML
    private TableColumn<Raspuns, Integer> raspunsPunctajColumn;

    @FXML
    private TableView<Raspuns> raspunsTableView;
    @FXML
    private TableColumn<Raspuns, String> numeStudentColumn;

    @FXML
    private TableColumn<Raspuns, Integer> numarIntrebareColumn;

    @FXML
    private TableColumn<Intrebare, Integer> punctajColumn;

    @FXML
    private TableColumn<Intrebare, String> raspunsCorectColumn;

    @FXML
    private TableView<Intrebare> tableViewIntrebari;

    @FXML
    private TableColumn<Intrebare, String> v1Column;

    @FXML
    private TableColumn<Intrebare, String> v2Column;

    @FXML
    private TableColumn<Intrebare, String> v3Column;

    ObservableList<Raspuns> raspunsuriList = FXCollections.observableArrayList();
    List<Raspuns> raspunsuri = new ArrayList<>();

    ObservableList<Intrebare> intrebariList = FXCollections.observableArrayList();

    ObservableList<Intrebare> testIntrebariList = FXCollections.observableArrayList();

    List<Intrebare> intrebariDate = new ArrayList<>();

    int currentPctMax = 0;
    public void setService(ServiceStudent serviceStudent, ServiceProfesor serviceProfesor){
        this.serviceStudent = serviceStudent;
        this.serviceProfesor = serviceProfesor;
        this.serviceProfesor.addObserver(this);
        initModule();
    }

    public void onPlaseazaIntrebareBtnPress(ActionEvent event){
        if(tableViewIntrebari.getSelectionModel().getSelectedItem() != null){
            Intrebare intrebare = tableViewIntrebari.getSelectionModel().getSelectedItem();
            currentPctMax += intrebare.getPunctaj();
            punctajMaximLabel.setText(Integer.toString(currentPctMax));
            intrebariList.remove(intrebare);
            setTable();
            intrebariDate.add(intrebare);
            testIntrebariList.setAll(intrebariDate);

            serviceStudent.addIntrebare(intrebare);

            setTableTest();
        }
    }

    public void setTable(){
        nrIntrebareColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, Integer>("nrIntrebare"));
        descriereColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("descriere"));
        v1Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v1"));
        v2Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v2"));
        v3Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v3"));
        raspunsCorectColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("raspunsCorect"));
        punctajColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, Integer>("punctaj"));

        tableViewIntrebari.setItems(intrebariList);
    }

    public void setRaspunsTable(){
        numarIntrebareColumn.setCellValueFactory(new PropertyValueFactory<Raspuns, Integer>("numarIntrebare"));
        numeStudentColumn.setCellValueFactory(new PropertyValueFactory<Raspuns, String>("numeStud"));
        raspunsPunctajColumn.setCellValueFactory(new PropertyValueFactory<Raspuns, Integer>("punctaj"));

        raspunsTableView.setItems(raspunsuriList);
    }

    public void setTableTest(){
        testNrIntrebareColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, Integer>("nrIntrebare"));
        testDescriereColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("descriere"));
        testV1Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v1"));
        testV2Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v2"));
        testV3Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v3"));
        testRaspunsColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("raspunsCorect"));
        testPunctajColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, Integer>("punctaj"));


        testTableView.setItems(testIntrebariList);
    }

    public void initModule(){

        List<Intrebare> intrebari = serviceProfesor.getAllIntrebari();
        intrebari.forEach(System.out::println);
        intrebariList.setAll(intrebari);

        setTable();

        plaseazaIntrebareBtn.setOnAction(this::onPlaseazaIntrebareBtnPress);

    }


    @Override
    public void update(RaspunsEvent raspunsEvent) {
        System.out.println(raspunsEvent.getData());

        raspunsuri = serviceProfesor.getAllRaspunsuri();
        raspunsuriList.setAll(raspunsuri);

        setRaspunsTable();

    }
}
