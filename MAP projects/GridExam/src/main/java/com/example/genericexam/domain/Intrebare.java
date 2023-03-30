package com.example.genericexam.domain;

import java.util.Objects;

public class Intrebare {
    private int nrIntrebare;
    private String descriere;
    private String v1;
    private String v2;
    private String v3;
    private String raspunsCorect;
    private int punctaj;

    public Intrebare(int nrIntrebare, String descriere, String v1, String v2, String v3, String raspunsCorect, int punctaj) {
        this.nrIntrebare = nrIntrebare;
        this.descriere = descriere;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.raspunsCorect = raspunsCorect;
        this.punctaj = punctaj;
    }

    public int getNrIntrebare() {
        return nrIntrebare;
    }

    public void setNrIntrebare(int nrIntrebare) {
        this.nrIntrebare = nrIntrebare;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    public String getRaspunsCorect() {
        return raspunsCorect;
    }

    public void setRaspunsCorect(String raspunsCorect) {
        this.raspunsCorect = raspunsCorect;
    }

    public int getPunctaj() {
        return punctaj;
    }

    public void setPunctaj(int punctaj) {
        this.punctaj = punctaj;
    }

    @Override
    public String toString() {
        return "Intrebare{" +
                "nrIntrebare=" + nrIntrebare +
                ", descriere='" + descriere + '\'' +
                ", v1='" + v1 + '\'' +
                ", v2='" + v2 + '\'' +
                ", v3='" + v3 + '\'' +
                ", raspunsCorect='" + raspunsCorect + '\'' +
                ", punctaj=" + punctaj +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intrebare intrebare = (Intrebare) o;
        return nrIntrebare == intrebare.nrIntrebare && punctaj == intrebare.punctaj && Objects.equals(descriere, intrebare.descriere) && Objects.equals(v1, intrebare.v1) && Objects.equals(v2, intrebare.v2) && Objects.equals(v3, intrebare.v3) && Objects.equals(raspunsCorect, intrebare.raspunsCorect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrIntrebare, descriere, v1, v2, v3, raspunsCorect, punctaj);
    }
}
