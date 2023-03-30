package com.example.genericexam.service;

import com.example.genericexam.domain.Final;
import com.example.genericexam.domain.Intrebare;
import com.example.genericexam.repository.RepositoryDbIntrebari;
import com.example.genericexam.utils.events.Event;
import com.example.genericexam.utils.events.FinishEvent;
import com.example.genericexam.utils.events.IntrebareEvent;
import com.example.genericexam.utils.observer.Observable;
import com.example.genericexam.utils.observer.Observer;

import java.util.*;

@SuppressWarnings("rawtypes")
public class ServiceStudent implements Observable {

    private final Map<Class<? extends Event>, Observable> observers;

    RepositoryDbIntrebari repoIntrebari;

//    private List<Observer<IntrebareEvent>> observers = new ArrayList<>();

    private Intrebare intrebareCurenta;
    @SuppressWarnings("rawtypes")
    public ServiceStudent(RepositoryDbIntrebari repoIntrebari) {

        this.repoIntrebari = repoIntrebari;
        Map<Class<? extends Event>, Observable> temp  = new HashMap<>();
        temp.put(IntrebareEvent.class, new IntrebareObservable());
        temp.put(FinishEvent.class, new FinishObservable());
        observers = Collections.unmodifiableMap(temp);
    }

    public List<Intrebare> getAllIntrebari(){
        return repoIntrebari.findAll();
    }

    public void addIntrebare(Intrebare intrebare){
        intrebareCurenta = intrebare;
        notifyObservers(new IntrebareEvent(intrebareCurenta));
    }

    public void addFinal(Final finalRasp){
        notifyObservers(new FinishEvent(finalRasp));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addObserver(Observer e) {
        observers.get(IntrebareEvent.class).addObserver(e);
        observers.get(FinishEvent.class).addObserver(e);
    }

    @Override
    public void removeObserver(Observer e) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public void notifyObservers(Event t) {
        if(observers.containsKey(t.getClass())){
            observers.get(t.getClass()).notifyObservers(t);
        }else {
            throw new IllegalArgumentException("Event not supported");
        }
    }

    private class IntrebareObservable implements Observable<IntrebareEvent>{

        private List<Observer<IntrebareEvent>> observers = new ArrayList<>();
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

    private class FinishObservable implements Observable<FinishEvent>{

        private List<Observer<FinishEvent>> observers = new ArrayList<>();
        @Override
        public void addObserver(Observer<FinishEvent> e) {
            observers.add(e);
        }

        @Override
        public void removeObserver(Observer<FinishEvent> e) {

        }

        @Override
        public void notifyObservers(FinishEvent t) {
            observers.stream().forEach(x -> x.update(t));
        }
    }
//    @Override
//    public void addObserver(Observer<IntrebareEvent> e) {
//        observers.add(e);
//    }
//
//    @Override
//    public void removeObserver(Observer<IntrebareEvent> e) {
//
//    }
//
//    @Override
//    public void notifyObservers(IntrebareEvent t) {
//        observers.stream().forEach(x -> x.update(t));
//    }
}
