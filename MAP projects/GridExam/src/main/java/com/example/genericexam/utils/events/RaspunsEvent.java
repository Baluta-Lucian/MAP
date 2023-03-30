package com.example.genericexam.utils.events;

import com.example.genericexam.domain.Raspuns;

public class RaspunsEvent implements Event{
    private Raspuns data, oldData;

    public RaspunsEvent(Raspuns data) {
        this.data = data;
    }

    public RaspunsEvent(Raspuns data, Raspuns oldData) {
        this.data = data;
        this.oldData = oldData;
    }

    public Raspuns getData() {
        return data;
    }

    public void setData(Raspuns data) {
        this.data = data;
    }

    public Raspuns getOldData() {
        return oldData;
    }

    public void setOldData(Raspuns oldData) {
        this.oldData = oldData;
    }
}
