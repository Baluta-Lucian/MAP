package org.example.domain;

import java.util.Objects;

public class Cursa implements Identifiable<Integer>{

    private int id;

    private String capacitate;

    private int numarParticipanti;



    public Cursa(String capacitate, int numarParticipanti) {
        this.capacitate = capacitate;
        this.numarParticipanti = numarParticipanti;
    }

    public String getCapacitate() {
        return capacitate;
    }


    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    public int getNumarParticipanti() {
        return numarParticipanti;
    }

    public void setNumarParticipanti(int numarParticipanti) {
        this.numarParticipanti = numarParticipanti;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public void updateParticipanti(Integer howMuch){
        this.numarParticipanti += howMuch;
    }

    @Override
    public void setID(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", capacitate=" + capacitate +
                ", numarParticipanti=" + numarParticipanti +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursa cursa = (Cursa) o;
        return capacitate == cursa.capacitate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacitate, numarParticipanti);
    }
}
