package com.example.genericexam.domain;

import java.util.Objects;

public class Raspuns {

    private int numarIntrebare;
    private String numeStud;
    private int punctaj;

    public Raspuns(int numarIntrebare, String numeStud, int punctaj) {
        this.numarIntrebare = numarIntrebare;
        this.numeStud = numeStud;
        this.punctaj = punctaj;
    }

    public int getNumarIntrebare() {
        return numarIntrebare;
    }

    public void setNumarIntrebare(int numarIntrebare) {
        this.numarIntrebare = numarIntrebare;
    }

    public String getNumeStud() {
        return numeStud;
    }

    public void setNumeStud(String numeStud) {
        this.numeStud = numeStud;
    }

    public int getPunctaj() {
        return punctaj;
    }

    public void setPunctaj(int punctaj) {
        this.punctaj = punctaj;
    }

    @Override
    public String toString() {
        return "Raspuns{" +
                "numarIntrebare=" + numarIntrebare +
                ", numeStud='" + numeStud + '\'' +
                ", punctaj=" + punctaj +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raspuns raspuns = (Raspuns) o;
        return numarIntrebare == raspuns.numarIntrebare && punctaj == raspuns.punctaj && Objects.equals(numeStud, raspuns.numeStud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarIntrebare, numeStud, punctaj);
    }
}
