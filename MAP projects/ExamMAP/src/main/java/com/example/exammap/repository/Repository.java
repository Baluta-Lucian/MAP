package com.example.exammap.repository;

import com.example.exammap.domain.Entity;

import java.util.List;

public interface Repository<ID, E extends Entity<ID>> {
    E findOne(ID id);

    List<E> findAll();

    E delete(ID id);

    E update(E entity);

}
