package com.example.vacanta.domain;

public class Entity <ID>{

    private ID id;

    public Entity(ID id) {this.id = id;
    }

    public ID getID(){
        return this.id;
    }

    public void setID(ID id){this.id = id;}


}

