package org.example.repository;

import org.example.domain.Participant;
import org.example.domain.cm3;

import java.util.List;

public interface ParticipantRepository extends Repository<Integer, Participant> {
    List<Participant> findByCapacitate(cm3 capacitate);
    List<Participant> findByTeam(String team);

}
