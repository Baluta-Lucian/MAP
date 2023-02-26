package com.example.vacanta.repository;

import com.example.vacanta.domain.Entity;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface Repository<ID, E extends Entity<ID>> {
    E findOne(ID id);

    List<E> findAll();

    E delete(ID id);

    E update(E entity);

}