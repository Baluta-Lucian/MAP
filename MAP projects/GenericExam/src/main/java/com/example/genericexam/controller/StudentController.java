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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentController implements Observer<IntrebareEvent> {
    ServiceStudent serviceStudent;
    ServiceProfesor serviceProfesor;

    @FXML
    private TableColumn<Intrebare, String> descriereColumn;

    @FXML
    private TableColumn<Intrebare, Integer> nrIntrebareColumn;

    @FXML
    private TableColumn<Intrebare, Integer> punctajColumn;

    @FXML
    private TableView<Intrebare> tableViewIntrebari;

    @FXML
    private TableColumn<Intrebare, String> v1Column;

    @FXML
    private TableColumn<Intrebare, String> v2Column;

    @FXML
    private RadioButton v1RadioBtn;

    @FXML
    private RadioButton v2RadioBtn;

    int aRaspuns = 0;

    @FXML
    private RadioButton v3RadioBtn;


    @FXML
    private Button trimiteRaspunsBtn;

    @FXML
    private TableColumn<Intrebare, String> v3Column;

    ObservableList<Intrebare> intrebariList = FXCollections.observableArrayList();



    String studentName;

    Intrebare currentIntrebare;

    int i = 1;


    public void setService(ServiceStudent serviceStudent, ServiceProfesor serviceProfesor){
        this.serviceStudent = serviceStudent;
        this.serviceProfesor = serviceProfesor;
        this.serviceStudent.addObserver(this);
        this.trimiteRaspunsBtn.setOnAction(this::onRaspunsButtonPressed);
        InitModel();
    }

    public void InitModel(){
        final ToggleGroup group = new ToggleGroup();
        v1RadioBtn.setToggleGroup(group);
        v2RadioBtn.setToggleGroup(group);
        v3RadioBtn.setToggleGroup(group);
    }

    public void setStudent(String studentName){
        this.studentName = studentName;
    }

    @FXML
    void onRaspunsButtonPressed(ActionEvent event){
        System.out.println("Am apasat butonul");
        String r = new String();
        if(v1RadioBtn.isSelected())
            r = v1RadioBtn.getText();
        else if(v2RadioBtn.isSelected())
            r = v2RadioBtn.getText();
        else if(v3RadioBtn.isSelected())
            r = v3RadioBtn.getText();
//        System.out.println(v1RadioBtn.getText());
//        System.out.println(v2RadioBtn.getText());
//        System.out.println(v3RadioBtn.getText());
        System.out.println(r);
        if(r.length() != 0 && aRaspuns == 0){
            aRaspuns = 1;
            Raspuns raspuns;
            if(r.equals(currentIntrebare.getRaspunsCorect())) {
                raspuns = new Raspuns(currentIntrebare.getNrIntrebare(), this.studentName, currentIntrebare.getPunctaj());
                serviceProfesor.addRaspuns(raspuns);
            }
            else{
                raspuns = new Raspuns(currentIntrebare.getNrIntrebare(), this.studentName, 0);
                serviceProfesor.addRaspuns(raspuns);
            }
        }
    }



    public void setTable(){
        nrIntrebareColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, Integer>("nrIntrebare"));
        descriereColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("descriere"));
        v1Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v1"));
        v2Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v2"));
        v3Column.setCellValueFactory(new PropertyValueFactory<Intrebare, String>("v3"));
        punctajColumn.setCellValueFactory(new PropertyValueFactory<Intrebare, Integer>("punctaj"));

        tableViewIntrebari.setItems(intrebariList);
    }

    @Override
    public void update(IntrebareEvent intrebareEvent) {
        aRaspuns = 0;
        Intrebare intrebare = intrebareEvent.getData();
        List<Intrebare> intrebareList = new ArrayList<>();
        intrebareList.add(intrebare);
        currentIntrebare = intrebare;
        if(!intrebariList.isEmpty())
            intrebariList.remove(0);
        intrebariList.setAll(intrebareList);

        setTable();

        v1RadioBtn.setText(intrebare.getV1());
        v2RadioBtn.setText(intrebare.getV2());
        v3RadioBtn.setText(intrebare.getV3());

    }
}
