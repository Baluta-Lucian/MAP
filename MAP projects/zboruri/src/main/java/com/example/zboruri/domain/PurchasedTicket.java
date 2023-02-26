package com.example.zboruri.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class PurchasedTicket {
    private Long id;
    private String from;
    private String to;
    private LocalDateTime departureTime;
    private LocalDateTime landingTime;
    private int seats;
    private int availableTickets;

    public PurchasedTicket(Flight zbor, int availableTickets) {
        this.id = zbor.getId();
        this.from = zbor.getFrom();
        this.to = zbor.getTo();
        this.departureTime = zbor.getDepartureTime();
        this.landingTime = zbor.getLandingTime();
        this.seats = zbor.getSeats();
        this.availableTickets = availableTickets;
    }

    public PurchasedTicket(Long id, String from, String to, LocalDateTime departureTime, LocalDateTime landingTime, int seats, int availableTickets) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
        this.seats = seats;
        this.availableTickets = availableTickets;
    }

    public Flight getFlight(){
        return new Flight(this.id, this.from, this.to, this.departureTime, this.landingTime, this.seats);
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

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    @Override
    public String toString() {
        return "PurchasedTicket{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureTime=" + departureTime +
                ", landingTime=" + landingTime +
                ", seats=" + seats +
                ", availableTickets=" + availableTickets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedTicket that = (PurchasedTicket) o;
        return seats == that.seats && availableTickets == that.availableTickets && Objects.equals(id, that.id) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(departureTime, that.departureTime) && Objects.equals(landingTime, that.landingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, departureTime, landingTime, seats, availableTickets);
    }
}
