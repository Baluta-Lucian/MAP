package com.example.genericexam.service;

import com.example.genericexam.domain.Intrebare;
import com.example.genericexam.repository.RepositoryDbIntrebari;
import com.example.genericexam.utils.events.IntrebareEvent;
import com.example.genericexam.utils.observer.Observable;
import com.example.genericexam.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ServiceStudent implements Observable<IntrebareEvent> {

    RepositoryDbIntrebari repoIntrebari;

    private List<Observer<IntrebareEvent>> observers = new ArrayList<>();

    private Intrebare intrebareCurenta;
    public ServiceStudent(RepositoryDbIntrebari repoIntrebari) {
        this.repoIntrebari = repoIntrebari;
    }

    public List<Intrebare> getAllIntrebari(){
        return repoIntrebari.findAll();
    }

    public void addIntrebare(Intrebare intrebare){
        intrebareCurenta = intrebare;
        notifyObservers(new IntrebareEvent(intrebareCurenta));
    }
    @Override
    public void addObserver(Observer<IntrebareEvent> e) {
        observers.add(e);
    }

    @Override
    public void removeObserver(Observer<IntrebareEvent> e) {

    }

    @Override
    public void notifyObservers(IntrebareEvent t) {
        observers.stream().forEach(x -> x.update(t));
    }
}
