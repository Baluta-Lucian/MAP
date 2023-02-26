package com.example.vacanta.domain;

import java.util.Objects;

public class Locatie extends Entity<Double>{

    private String locationName;

    public Locatie(Double locationId, String locationName) {
        super(locationId);
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locatie locatie = (Locatie) o;
        return Objects.equals(locationName, locatie.locationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName);
    }
}
