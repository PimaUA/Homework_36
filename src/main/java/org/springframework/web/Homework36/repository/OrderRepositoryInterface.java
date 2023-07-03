package org.springframework.web.Homework36.repository;

import org.springframework.web.Homework36.entity.Order;

import java.util.List;

public interface OrderRepositoryInterface {

    List<Order> getAll();

    Order getById(int id);

    void add(Order order);
}
