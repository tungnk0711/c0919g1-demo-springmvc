package com.codegym.service;

import java.util.List;

public interface IGeneralService<E> {

    List<E> findAllHaveBusiness();
    E findById(Long id);
    E findByName(String name);
    void save(E e);
}
