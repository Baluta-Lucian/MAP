package com.example.exammap.domain;

import java.util.Objects;

public class TrainStation {

    private String trainId;
    private String departureCityId;

    private String destinationCityId;

    public TrainStation(String trainId, String departureCityId, String destinationCityId) {
        this.trainId = trainId;
        this.departureCityId = departureCityId;
        this.destinationCityId = destinationCityId;
    }

    public String getTrainId(){
        return trainId;
    }

    public String getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(String departureCityId) {
        this.departureCityId = departureCityId;
    }

    public String getDestinationCityId() {
        return destinationCityId;
    }

    public void setDestinationCityId(String destinationCityId) {
        this.destinationCityId = destinationCityId;
    }

    @Override
    public String toString() {
        return "TrainStation{" +
                "departureCityId='" + departureCityId + '\'' +
                ", destinationCityId='" + destinationCityId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainStation that = (TrainStation) o;
        return Objects.equals(departureCityId, that.departureCityId) && Objects.equals(destinationCityId, that.destinationCityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCityId, destinationCityId);
    }
}
