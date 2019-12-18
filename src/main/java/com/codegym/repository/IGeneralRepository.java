package com.codegym.repository;

import java.util.List;

public interface IGeneralRepository<E> {
    List<E> findAll();
    E findById(Long id);
    E findByName(String name);
    void save(E e);
}
