package com.example.genericexam.utils.events;

import com.example.genericexam.domain.Final;
import com.example.genericexam.domain.Intrebare;

public class FinishEvent implements Event{


    private Final data, oldData;

    public FinishEvent(Final data) {
        this.data = data;
    }

    public FinishEvent(Final data, Final oldData) {
        this.data = data;
        this.oldData = oldData;
    }

    public Final getData() {
        return data;
    }

    public void setData(Final data) {
        this.data = data;
    }

    public Final getOldData() {
        return oldData;
    }

    public void setOldData(Final oldData) {
        this.oldData = oldData;
    }

}
