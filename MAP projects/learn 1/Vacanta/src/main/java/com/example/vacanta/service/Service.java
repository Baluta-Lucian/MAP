package com.example.vacanta.service;

import com.example.vacanta.domain.Hotel;
import com.example.vacanta.domain.Locatie;
import com.example.vacanta.domain.SpecialOffer;
import com.example.vacanta.repository.db.RepositoryDbHoteluri;
import com.example.vacanta.repository.db.RepositoryDbLocatii;
import com.example.vacanta.repository.db.RepositoryDbSpecialOffers;

import java.time.LocalDate;
import java.util.*;

public class Service {

    private RepositoryDbLocatii repoLoc;
    private RepositoryDbHoteluri repoHot;

    private RepositoryDbSpecialOffers repoSpeOff;

    public Service(RepositoryDbLocatii repoLoc, RepositoryDbHoteluri repoHot, RepositoryDbSpecialOffers repoSpeOff) {
        this.repoLoc = repoLoc;
        this.repoHot = repoHot;
        this.repoSpeOff = repoSpeOff;
    }

    public List<Locatie> getLocations(){
        return repoLoc.findAll();
    }

    public List<Hotel> searchHotelsInLocation(Locatie locatie){
        List<Hotel> hotels = repoHot.findAll();
        List<Hotel> reqList = new ArrayList<>();

        for(Hotel hotel : hotels){
            if(hotel.getLocatie().equals(locatie.getID())){
                reqList.add(hotel);
            }
        }

        return reqList;
    }

    public List<Hotel> getHotels(){
        return repoHot.findAll();
    }

    public List<SpecialOffer> searchOfferByHotelAndDate(Hotel hotel, LocalDate date){
        List<SpecialOffer> specialOffers = repoSpeOff.findAll();
        List<SpecialOffer> reqList = new ArrayList<>();

        for(SpecialOffer specialOffer : specialOffers){
            if (specialOffer.getHotelId() == (double) hotel.getID())
                if(specialOffer.getStartDate().compareTo(date) <= 0)
                    if(specialOffer.getEndDate().compareTo(date) >= 0)
                        reqList.add(specialOffer);
        }
        return reqList;
    }

    public List<SpecialOffer> getSpecialOffers(){
        return repoSpeOff.findAll();
    }

}
