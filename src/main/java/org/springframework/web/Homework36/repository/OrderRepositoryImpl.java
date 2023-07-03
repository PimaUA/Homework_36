package org.springframework.web.Homework36.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.Homework36.entity.Order;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Order> getAll() {
        Query query=entityManager.createQuery("From Order");
        return query.getResultList();
    }

    @Override
    public Order getById(int id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void add(Order order) {
        Order newOrder=entityManager.merge(order);
        order.setId(newOrder.getId());
    }
}
