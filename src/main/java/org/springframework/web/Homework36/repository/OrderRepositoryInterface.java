package org.springframework.web.Homework36.repository;

import org.springframework.web.Homework36.entity.Order;

import java.util.List;

public interface OrderRepositoryInterface {

    public List<Order> getAll();

    public Order getById(int id);

    public void add(Order order);
}
