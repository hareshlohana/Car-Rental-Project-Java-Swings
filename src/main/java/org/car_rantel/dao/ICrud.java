package org.car_rantel.dao;

import org.car_rantel.domain.Customer;

import java.util.List;

public interface ICrud <T> {
    void insert(T obj);
    List<T> getAll();
    T getById(Long id);
    void update(T obj, Integer index);

    List<Customer> deleteByID(Long id);
}
