package org.example.domain;

import java.util.Objects;

public class Participant implements Identifiable<Integer>{
    // id, nume, capacitate, team(poate fii null)
    private int id;
    String nume;
    cm3 capacitate;
    String team;

    public Participant(String nume, cm3 capacitate, String team) {
        this.nume = nume;
        this.capacitate = capacitate;
        this.team = team;
    }
    public Participant(String nume, cm3 capacitate) {
        this.nume = nume;
        this.capacitate = capacitate;
        this.team = "";
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCapacitate() {
        return String.valueOf(this.capacitate);
    }

    public cm3 getCapacitateCm3(){
        return this.capacitate;
    }

    public void setCapacitate(cm3 capacitate) {
        this.capacitate = capacitate;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public void setID(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "nume='" + nume + '\'' +
                ", cm3=" + capacitate.label +
                ", team='" + team + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return id == that.id && Objects.equals(nume, that.nume) && Objects.equals(capacitate, that.capacitate) && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, capacitate, team);
    }
}
