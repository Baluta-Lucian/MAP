package org.example.service;

import org.example.domain.Cursa;
import org.example.domain.Participant;
import org.example.domain.TableParticipantHelper;
import org.example.domain.cm3;
import org.example.repository.ParticipantDbRepository;

import java.util.ArrayList;
import java.util.List;

public class ServiceParticipant {

    private ParticipantDbRepository repoParticipanti;

    public ServiceParticipant(ParticipantDbRepository repoParticipanti) {
        this.repoParticipanti = repoParticipanti;
    }

    public List<Cursa> getCurse(){
        List<Cursa> curse = new ArrayList<>();

        for(Participant p : repoParticipanti.findAll()){
            Cursa c = new Cursa(p.getCapacitateCm3().label, 1);
            if(curse.contains(c)){
                int index = curse.indexOf(c);
                curse.get(index).updateParticipanti(c.getNumarParticipanti());
            }
            else{
                curse.add(c);
            }
        }
        curse.sort((Cursa c1, Cursa c2) -> c2.getCapacitate().compareTo(c1.getCapacitate()));
        return curse;
    }

    public List<TableParticipantHelper> findParticipantiByTeam(String team){
        List<TableParticipantHelper> teamParticipanti = new ArrayList<>();
        for (Participant p : repoParticipanti.findByTeam(team)){
            teamParticipanti.add(new TableParticipantHelper(p));
        }
        return teamParticipanti;
    }

    public void addParticipant(String nume, String echipa, cm3 capacitate){
        Participant participant = new Participant(nume, capacitate, echipa);
        repoParticipanti.add(participant);
    }
}
