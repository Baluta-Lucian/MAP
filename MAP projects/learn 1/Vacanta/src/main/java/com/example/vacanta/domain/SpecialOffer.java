package com.example.vacanta.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class SpecialOffer extends Entity<Double>{



    private double hotelId;

    private LocalDate startDate;

    private LocalDate endDate;

    private int percents;

    public SpecialOffer(Double specialOfferId, double hotelId, LocalDate startDate, LocalDate endDate, int percents) {
        super(specialOfferId);
        this.hotelId = hotelId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percents = percents;
    }

    public double getHotelId() {
        return hotelId;
    }

    public void setHotelId(double hotelId) {
        this.hotelId = hotelId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPercents() {
        return percents;
    }

    public void setPercents(int percents) {
        this.percents = percents;
    }

    @Override
    public String toString() {
        return "SpecialOffer{" +
                "hotelId=" + hotelId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", percents=" + percents +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialOffer that = (SpecialOffer) o;
        return Double.compare(that.hotelId, hotelId) == 0 && percents == that.percents && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, startDate, endDate, percents);
    }
}
