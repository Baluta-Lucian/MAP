package com.example.lab4mpp.model;

public interface Identifiable<Tid> {
    Tid getID();
    void setID(Tid id);
}