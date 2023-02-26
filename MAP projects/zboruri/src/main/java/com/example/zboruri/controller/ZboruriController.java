package com.example.zboruri.controller;

import com.example.zboruri.domain.Client;
import com.example.zboruri.domain.Flight;
import com.example.zboruri.domain.PurchasedTicket;
import com.example.zboruri.domain.Ticket;
import com.example.zboruri.service.Service;
import com.example.zboruri.utils.events.PurchasedTicketEvent;
import com.example.zboruri.utils.observer.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ZboruriController implements Observer<PurchasedTicketEvent> {
    Service service;

    private int id;

    public void setId(int id){this.id = id;}


    @FXML
    private TableColumn<PurchasedTicket, Integer> availableColumn;
    @FXML
     TableColumn<PurchasedTicket, LocalDateTime> departureTimeColumn;

    @FXML
     TableColumn<PurchasedTicket, Long> flightIdColumn;

    @FXML
     TableColumn<PurchasedTicket, String> fromColumn;

    @FXML
     TableColumn<PurchasedTicket, LocalDateTime> landingTimeColumn;

    @FXML
     TableColumn<PurchasedTicket, Integer> seatsColumn;

    @FXML
     TableColumn<PurchasedTicket, String> toColumn;

    @FXML
     DatePicker myDatePicker;

    private Client clientCurent;


    ObservableList<String> listaZboruriCombo = FXCollections.observableArrayList();
    ObservableList<Flight> model = FXCollections.observableArrayList();

    ObservableList<Flight> listaTableView = FXCollections.observableArrayList();

    ObservableList<PurchasedTicket> listaPurchasedTicket = FXCollections.observableArrayList();

    @FXML
     ComboBox fromComboBox;

    @FXML
    Button cumparaBtn;

    @FXML
     ComboBox toComboBox;

    @FXML
     TableView<PurchasedTicket> zboruriTableView;

    public ZboruriController() throws IOException{}
    public void setService(Service service){
        this.service = service;
        service.addObserver(this);
        initModel();
    }

    public void setUserData(Client clientCurent){
        this.clientCurent = clientCurent;
    }


    public void getElemsForTable(Event event){
        String from = (String) fromComboBox.getSelectionModel().getSelectedItem();
        String to = (String) toComboBox.getSelectionModel().getSelectedItem();

        if(from != null && to != null && myDatePicker.getValue() != null) {
            LocalDateTime departure = myDatePicker.getValue().atStartOfDay();
            service.filterZboruri(from, to, departure).forEach(System.out::println);
            listaTableView.setAll(service.filterZboruri(from, to, departure));
            for(Flight f : listaTableView){
                if(service.findOneTicket(f.getId()) != null)
                    listaPurchasedTicket.add(service.findOneTicket(f.getId()));
                else {
                    listaPurchasedTicket.add(new PurchasedTicket(f, f.getSeats()));
                    service.saveTicket(new PurchasedTicket(f, f.getSeats()));
                }
            }

            //tabel
            flightIdColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, Long>("id"));
            fromColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, String>("from"));
            toColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, String>("to"));
            departureTimeColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, LocalDateTime>("departureTime"));
            landingTimeColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, LocalDateTime>("landingTime"));
            seatsColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, Integer>("seats"));
            availableColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, Integer>("availableTickets"));

            zboruriTableView.setItems(listaPurchasedTicket);
        }

    }


    public void initModel(){
        service.getAllZboruri().forEach(System.out::println);
        model.setAll(service.getAllZboruri());
        List<String> numeLocatii = new ArrayList<>();
        for(Flight f : service.getAllZboruri()){
            if(!numeLocatii.contains(f.getFrom()))
                numeLocatii.add(f.getFrom());
            if(!numeLocatii.contains(f.getTo()))
                numeLocatii.add(f.getTo());
        }
        listaZboruriCombo.setAll(numeLocatii);
    }


    public void onCumparaBtnPress(ActionEvent Event){
        if(zboruriTableView.getSelectionModel().getSelectedItem() != null){
            PurchasedTicket purchasedTicket = zboruriTableView.getSelectionModel().getSelectedItem();
            Ticket ticket = new Ticket(this.clientCurent.getUsername(), purchasedTicket.getId(), LocalDateTime.now());
            System.out.println(ticket);
            purchasedTicket.setAvailableTickets(purchasedTicket.getAvailableTickets() - 1);
            service.saveTicket(purchasedTicket);
        }
    }


    @FXML
    public void initialize(){
        fromComboBox.setItems(listaZboruriCombo);
        toComboBox.setItems(listaZboruriCombo);
        fromComboBox.setOnAction(this::getElemsForTable);
        toComboBox.setOnAction(this::getElemsForTable);
        myDatePicker.setOnAction(this::getElemsForTable);
        cumparaBtn.setOnAction(this::onCumparaBtnPress);
    }

    @Override
    public void update(PurchasedTicketEvent purchasedTicketEvent) {
        //@TODO : cerinta 4), vezi ca poti pentru fiecare entitate sa
        //      : faci search si sa o modifici sau atunci cand se
        //      : intampla purchasedTicketEvent sa dai update in BD
        //      : si actualizezi informatia la toti <3
        //      : atunci cand apesi pe buton de cumparare
        //      : faci entitate noua si incerci sa o salvezi
        //      : daca exista, dai update si notify

        String from = (String) fromComboBox.getSelectionModel().getSelectedItem();
        String to = (String) toComboBox.getSelectionModel().getSelectedItem();

        if(from != null && to != null && myDatePicker.getValue() != null) {
            LocalDateTime departure = myDatePicker.getValue().atStartOfDay();
            service.filterZboruri(from, to, departure).forEach(System.out::println);
            listaTableView.setAll(service.filterZboruri(from, to, departure));
            int size = listaPurchasedTicket.size();
            while(!listaPurchasedTicket.isEmpty()){
                listaPurchasedTicket.remove(listaPurchasedTicket.get(0));
            }
            for(Flight f : listaTableView){
                if(service.findOneTicket(f.getId()) != null)
                    listaPurchasedTicket.add(service.findOneTicket(f.getId()));

            }

            //tabel
            flightIdColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, Long>("id"));
            fromColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, String>("from"));
            toColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, String>("to"));
            departureTimeColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, LocalDateTime>("departureTime"));
            landingTimeColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, LocalDateTime>("landingTime"));
            seatsColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, Integer>("seats"));
            availableColumn.setCellValueFactory(new PropertyValueFactory<PurchasedTicket, Integer>("availableTickets"));

            zboruriTableView.setItems(listaPurchasedTicket);
        }


    }

//    public void modifyTable(){
//
//    }



}
