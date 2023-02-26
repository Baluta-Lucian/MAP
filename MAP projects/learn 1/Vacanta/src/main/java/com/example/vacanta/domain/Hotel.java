package com.example.vacanta.domain;

import java.util.Objects;

public class Hotel extends Entity<Double> {

    private Double locationId;
    private String hotelName;
    private int noRooms;
    private double pricePerNight;
    private Type type;

    public Hotel(Double hotelId, Double locationId, String hotelName, int noRooms, double pricePerNight, Type type) {
        super(hotelId);
        this.locationId = locationId;
        this.hotelName = hotelName;
        this.noRooms = noRooms;
        this.pricePerNight = pricePerNight;
        this.type = type;
    }

    public Double getLocatie() {
        return this.locationId;
    }

    public void setLocatie(Double locationId) {
        this.locationId = locationId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getNoRooms() {
        return noRooms;
    }

    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "locatie=" + locationId +
                ", hotelName='" + hotelName + '\'' +
                ", noRooms=" + noRooms +
                ", pricePerNight=" + pricePerNight +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return noRooms == hotel.noRooms && Double.compare(hotel.pricePerNight, pricePerNight) == 0 && Objects.equals(locationId, hotel.locationId) && Objects.equals(hotelName, hotel.hotelName) && type == hotel.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, hotelName, noRooms, pricePerNight, type);
    }
}
