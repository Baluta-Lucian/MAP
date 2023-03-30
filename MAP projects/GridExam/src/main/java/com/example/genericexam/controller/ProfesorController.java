package com.example.genericexam.controller;

import com.example.genericexam.domain.Final;
import com.example.genericexam.domain.Intrebare;
import com.example.genericexam.domain.Raspuns;
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

    private int s1Pct = 0;
    private int s2Pct = 0;
    private int s3Pct = 0;

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
    private Button finishTestBtn;

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

    private int currentPctMax = 0;
    public void setService(ServiceStudent serviceStudent, ServiceProfesor serviceProfesor){
        this.serviceStudent = serviceStudent;
        this.serviceProfesor = serviceProfesor;
        this.serviceProfesor.addObserver(this);
        initModule();
    }

    public void setStudenti(String s1, String s2, String s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
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

    public void onFinishTestBtnPress(ActionEvent event){
        raspunsuriList.clear();
        setRaspunsTable();
        Final s1Final = new Final(this.s1, this.s1Pct, this.currentPctMax);
        Final s2Final = new Final(this.s2, this.s2Pct, this.currentPctMax);
        Final s3Final = new Final(this.s3, this.s3Pct, this.currentPctMax);

        this.s1Pct = 0;
        this.s2Pct = 0;
        this.s3Pct = 0;

        serviceStudent.addFinal(s1Final);
        serviceStudent.addFinal(s2Final);
        serviceStudent.addFinal(s3Final);

        this.currentPctMax = 0;

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
        finishTestBtn.setOnAction(this::onFinishTestBtnPress);

    }




    @Override
    public void update(RaspunsEvent raspunsEvent) {
        System.out.println(raspunsEvent.getData());

        raspunsuri = serviceProfesor.getAllRaspunsuri();
        Raspuns ultimulRaspuns = raspunsuri.get(raspunsuri.size()-1);
        if(ultimulRaspuns.getNumeStud().equals(this.s1)){
            this.s1Pct += ultimulRaspuns.getPunctaj();
        }
        if(ultimulRaspuns.getNumeStud().equals(this.s2)){
            this.s2Pct += ultimulRaspuns.getPunctaj();
        }
        if(ultimulRaspuns.getNumeStud().equals(this.s3)){
            this.s3Pct += ultimulRaspuns.getPunctaj();
        }
        raspunsuriList.setAll(raspunsuri);

        setRaspunsTable();

    }
}
