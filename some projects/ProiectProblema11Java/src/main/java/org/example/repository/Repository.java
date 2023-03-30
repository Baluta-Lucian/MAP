package org.example.repository;

import java.util.List;

public interface Repository<ID, T> {
    void add(T elem);
    void update(ID id, T elem);
    List<T> findAll();
}
