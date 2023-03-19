package org.example.domain;

import java.util.Objects;

public class Participant implements Identifiable<Integer>{
    // id, nume, cm3, team(poate fii null)
    private int id;
    String nume;
    Integer cm3;
    String team;

    public Participant(int id, String nume, Integer cm3, String team) {
        this.id = id;
        this.nume = nume;
        this.cm3 = cm3;
        this.team = team;
    }
    public Participant(int id, String nume, Integer cm3) {
        this.id = id;
        this.nume = nume;
        this.cm3 = cm3;
        this.team = "";
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getCm3() {
        return cm3;
    }

    public void setCm3(Integer cm3) {
        this.cm3 = cm3;
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
                ", cm3=" + cm3 +
                ", team='" + team + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return id == that.id && Objects.equals(nume, that.nume) && Objects.equals(cm3, that.cm3) && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, cm3, team);
    }
}
