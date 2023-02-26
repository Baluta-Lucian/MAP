package com.example.zboruri.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private Long id;
    private String from;
    private String to;
    private LocalDateTime departureTime;
    private LocalDateTime landingTime;
    private int seats;


    public Flight(Long id, String from, String to, LocalDateTime departureTime, LocalDateTime landingTime, int seats) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(LocalDateTime landingTime) {
        this.landingTime = landingTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureTime=" + departureTime +
                ", landingTime=" + landingTime +
                ", seats=" + seats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return seats == flight.seats && Objects.equals(id, flight.id) && Objects.equals(from, flight.from) && Objects.equals(to, flight.to) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(landingTime, flight.landingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, departureTime, landingTime, seats);
    }
}
