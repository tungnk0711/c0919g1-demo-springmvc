package com.codegym.repository;

import java.util.List;

public interface IGeneralRepository<E> {
    List<E> findAll();
}
