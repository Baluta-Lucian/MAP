package org.example.repository;

import org.example.domain.Entity;

import java.util.Iterator;
import java.util.Optional;

public interface Repository<ID, E extends Entity<ID>> {
    Optional<E> findOne(ID id);

    Iterable<E> findAll();

    Optional<E> delete(ID id);

    Optional<E> update(E entity);

}
