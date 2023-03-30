package org.example.domain;

import java.util.Objects;

public class TableParticipantHelper {
    private String nume;
    private String capacitate;

    public TableParticipantHelper(String nume, String capacitate) {
        this.nume = nume;
        this.capacitate = capacitate;
    }

    public TableParticipantHelper(Participant participant){
        this.nume = participant.getNume();
        this.capacitate = participant.getCapacitateCm3().label;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    @Override
    public String toString() {
        return "TableParticipantHelper{" +
                "nume='" + nume + '\'' +
                ", capacitate='" + capacitate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableParticipantHelper that = (TableParticipantHelper) o;
        return Objects.equals(nume, that.nume) && Objects.equals(capacitate, that.capacitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, capacitate);
    }
}
