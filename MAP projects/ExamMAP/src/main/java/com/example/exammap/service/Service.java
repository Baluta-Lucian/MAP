package com.example.exammap.service;

import com.example.exammap.domain.City;
import com.example.exammap.domain.TrainStation;
import com.example.exammap.repository.db.RepositoryDbCities;
import com.example.exammap.repository.db.RepositoryDbStatii;
import javafx.scene.layout.Pane;

import java.util.*;

public class Service {
    private RepositoryDbCities repoOrase;

    private RepositoryDbStatii repoStatii;

    public Service(RepositoryDbCities repoOrase, RepositoryDbStatii repoStatii) {
        this.repoOrase = repoOrase;
        this.repoStatii = repoStatii;
    }

    public List<City> getCities(){
        return repoOrase.findAll();
    }

    public List<TrainStation> getStatii(){
        return repoStatii.findAll();
    }

    public LinkedList<TrainStation> filterTrains(String trainId){
        LinkedList<TrainStation> reqList = new LinkedList<>();
        List<TrainStation> statii = repoStatii.findAll();

        for(TrainStation trainStation : statii){
            if(trainStation.getTrainId().equals(trainId))
                reqList.add(trainStation);
        }
        return reqList;
    }

    private boolean checkIfTrain(List<TrainStation> statii, City c2){
        boolean rasp = false;
        for(TrainStation t : statii){
            if(t.getDestinationCityId().equals(c2.getID())){
                rasp = true;
            }
        }
        return rasp;
    }

    public List<TrainStation> routesForChecked(City c1,City c2){
        if(c1.getID().equals(c2.getID()))
            return new ArrayList<>();
        List<TrainStation> statii = repoStatii.findAll();
        List<TrainStation> reqList = new ArrayList<>();

        for (TrainStation trainStation : statii) {
            if (trainStation.getDestinationCityId().equals(c1.getID())) {
                String id = trainStation.getTrainId();
                reqList = this.filterTrains(id);
                break;
            }
        }

        if(checkIfTrain(reqList, c2)){
            return reqList;
        }else{
            return new ArrayList<>();
        }

    }

//
//    public List<TrainStation> dfs(City c1, City c2) {
//        List<TrainStation> statii = repoStatii.findAll();
//        List<TrainStation> reqList = new ArrayList<>();
//        List<TrainStation> listOfFiltered = new ArrayList<>();
//
//
//        for (TrainStation trainStation : statii) {
//            if (trainStation.getDestinationCityId().equals(c1.getID())) {
//                String id = trainStation.getID();
//                listOfFiltered = this.filterTrains(id);
//                break;
//            }
//        }
//        int v = listOfFiltered.size();
//        LinkedList<String>[] adj;
//        adj = new LinkedList[v];
//        for(int i = 0; i < adj.length; i++){
//            TrainStation station = listOfFiltered.get(0);
//            adj[i] = new LinkedList<String>();
//        }
//
//        for(int i = 0; i < v; i++){
//            adj[i].add()
//        }
//
//
//        return null;
//
//    }


    ////
//    public List<TrainStation> dfs(City c1, City c2) {
//        List<TrainStation> statii = repoStatii.findAll();
//        List<TrainStation> reqList = new ArrayList<>();
//        List<TrainStation> listOfFiltered = new ArrayList<>();
//
//
//        for (TrainStation trainStation : statii) {
//            if (trainStation.getDestinationCityId().equals(c1.getID())) {
//                String id = trainStation.getID();
//                listOfFiltered = this.filterTrains(id);
//                break;
//            }
//        }
//
//        Map<String, Boolean> viz = new HashMap<>();
//        listOfFiltered.forEach((x) -> {viz.put(x.getID(), false);});
//
//
//    }
//
//    private void DFSList(Map<String, Boolean> viz, TrainStation crtStation, ArrayList<TrainStation> list){
//
//        viz.remove(crtStation.getID());
//        viz.put(crtStation.getID(), true);
//        list.add(crtStation);
//
//    }
}
