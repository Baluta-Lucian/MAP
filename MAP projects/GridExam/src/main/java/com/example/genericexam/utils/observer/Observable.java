package com.example.genericexam.utils.observer;

import com.example.genericexam.utils.events.Event;

public interface Observable <E extends Event> {

    void addObserver(Observer<E> e);
    void removeObserver(Observer<E> e);
    void notifyObservers(E t);

}
