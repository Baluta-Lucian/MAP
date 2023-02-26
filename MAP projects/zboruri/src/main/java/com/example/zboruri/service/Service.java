package com.example.zboruri.service;

import com.example.zboruri.domain.Client;
import com.example.zboruri.domain.Flight;
import com.example.zboruri.domain.PurchasedTicket;
import com.example.zboruri.repository.RepositoryDbClienti;
import com.example.zboruri.repository.RepositoryDbPurchasedTicket;
import com.example.zboruri.repository.RepositoryDbZboruri;
import com.example.zboruri.utils.events.PurchasedTicketEvent;
import com.example.zboruri.utils.observer.Observable;
import com.example.zboruri.utils.observer.Observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Service implements Observable<PurchasedTicketEvent> {

    private RepositoryDbZboruri repoZboruri;
    private RepositoryDbClienti repoClienti;
    private RepositoryDbPurchasedTicket repoTichete;

    public Service(RepositoryDbZboruri repoZboruri, RepositoryDbClienti repoClienti, RepositoryDbPurchasedTicket repoTichete) {
        this.repoZboruri = repoZboruri;
        this.repoClienti = repoClienti;
        this.repoTichete = repoTichete;
    }

    public List<Flight> getAllZboruri(){
        return repoZboruri.findAll();
    }
    public List<Flight> filterZboruri(String from, String to, LocalDateTime departure){
        List<Flight> flights = new ArrayList<>();
        for(Flight f : getAllZboruri()){
            if(Objects.equals(f.getFrom(), from) && Objects.equals(f.getTo(), to) && f.getDepartureTime().toString().equals(departure.toString()))
                flights.add(f);
        }
        return flights;
    }

    public List<Client> getAllClienti(){return repoClienti.findAll();}

    public Client saveClient(Client client){
        if(repoClienti.findOne(client.getUsername()) == null)
            return repoClienti.save(client);
        return null;
    }

    public void saveTicket(PurchasedTicket ticket){
        PurchasedTicket gasit = repoTichete.findOne(ticket.getId());
        if(gasit == null){
            repoTichete.save(ticket);
        }
        else if(gasit.getAvailableTickets() != ticket.getAvailableTickets()){
            repoTichete.update(ticket);
            notifyObservers(new PurchasedTicketEvent(ticket));
        }
    }

    public PurchasedTicket findOneTicket(Long id){
        return repoTichete.findOne(id);
    }

    private List<Observer<PurchasedTicketEvent>> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer<PurchasedTicketEvent> e) {
        observers.add(e);
    }

    @Override
    public void removeObserver(Observer<PurchasedTicketEvent> e) {
        
    }

    @Override
    public void notifyObservers(PurchasedTicketEvent t) {
        observers.stream().forEach(x -> x.update(t));
    }
}
