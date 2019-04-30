package com.itgirl.project.worktracker.services.abstract_service;

import java.util.List;

public interface ServiceHelper<T> {

    List<T> getAll();

    T getById(Long id);

    T save(T object);

    void remove(T object);

    void removeById(Long id);

    long count();
}
