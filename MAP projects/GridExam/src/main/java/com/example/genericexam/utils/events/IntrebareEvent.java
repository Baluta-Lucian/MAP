package com.example.genericexam.utils.events;

import com.example.genericexam.domain.Intrebare;

public class IntrebareEvent implements Event{

    private Intrebare data, oldData;

    public IntrebareEvent(Intrebare data) {
        this.data = data;
    }

    public IntrebareEvent(Intrebare data, Intrebare oldData) {
        this.data = data;
        this.oldData = oldData;
    }

    public Intrebare getData() {
        return data;
    }

    public void setData(Intrebare data) {
        this.data = data;
    }

    public Intrebare getOldData() {
        return oldData;
    }

    public void setOldData(Intrebare oldData) {
        this.oldData = oldData;
    }
}
