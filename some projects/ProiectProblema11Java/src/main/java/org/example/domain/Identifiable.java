package org.example.domain;

public interface Identifiable<ID>{
    ID getID();
    void setID(ID id);
}
