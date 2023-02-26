package com.example.zboruri.utils.events;

import com.example.zboruri.domain.PurchasedTicket;

public class PurchasedTicketEvent implements Event{
    private PurchasedTicket data, oldData;

    public PurchasedTicketEvent(PurchasedTicket data){
        this.data = data;
    }

    public PurchasedTicketEvent(PurchasedTicket data, PurchasedTicket oldData) {
        this.data = data;
        this.oldData = oldData;
    }

    public PurchasedTicket getData() {
        return data;
    }

    public PurchasedTicket getOldData() {
        return oldData;
    }
}
