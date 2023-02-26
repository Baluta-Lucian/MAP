package com.example.zboruri.utils.observer;

import com.example.zboruri.utils.events.Event;

public interface Observer <E extends Event> {

    void update(E e);
}
