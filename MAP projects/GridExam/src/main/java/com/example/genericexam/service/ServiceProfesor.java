package com.example.genericexam.service;

import com.example.genericexam.domain.Intrebare;
import com.example.genericexam.domain.Raspuns;
import com.example.genericexam.repository.RepositoryDbIntrebari;
import com.example.genericexam.utils.events.IntrebareEvent;
import com.example.genericexam.utils.events.RaspunsEvent;
import com.example.genericexam.utils.observer.Observable;
import com.example.genericexam.utils.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ServiceProfesor implements Observable<RaspunsEvent> {

    RepositoryDbIntrebari repoIntrebari;

    private List<Raspuns> raspunsuri = new ArrayList<>();

    private List<Observer<RaspunsEvent>> observers = new ArrayList<>();

    public ServiceProfesor(RepositoryDbIntrebari repoIntrebari) {
        this.repoIntrebari = repoIntrebari;
    }

    public List<Intrebare> getAllIntrebari(){
        return repoIntrebari.findAll();
    }

    public void addRaspuns(Raspuns raspuns){
        raspunsuri.add(raspuns);
        notifyObservers(new RaspunsEvent(raspuns));
    }

    public List<Raspuns> getAllRaspunsuri(){
        return this.raspunsuri;
    }

    public List<Raspuns> getRaspunsuriByStudent(String student){
        List<Raspuns> raspunsuriStudent = new ArrayList<Raspuns>();
        for (Raspuns r : this.raspunsuri){
            if (r.getNumeStud().equals(student))
                raspunsuriStudent.add(r);
        }
        return raspunsuriStudent;
    }

    @Override
    public void addObserver(Observer<RaspunsEvent> e) {
        observers.add(e);
    }

    @Override
    public void removeObserver(Observer<RaspunsEvent> e) {

    }

    @Override
    public void notifyObservers(RaspunsEvent t) {
        observers.stream().forEach(x -> x.update(t));
    }
}
