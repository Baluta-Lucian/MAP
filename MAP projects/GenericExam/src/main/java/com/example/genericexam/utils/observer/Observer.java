package com.example.genericexam.utils.observer;

import com.example.genericexam.utils.events.Event;

public interface Observer <E extends Event> {

    void update(E e);
}