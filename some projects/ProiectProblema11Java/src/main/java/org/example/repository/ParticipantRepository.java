package org.example.repository;

import org.example.domain.Participant;

import java.util.List;

public interface ParticipantRepository extends Repository<Integer, Participant> {
    List<Participant> findByCm3(Integer cm3);
    List<Participant> findByTeam(String team);

}
