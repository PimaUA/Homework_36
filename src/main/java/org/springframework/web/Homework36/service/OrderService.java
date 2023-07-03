package org.springframework.web.Homework36.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.Homework36.entity.Order;
import org.springframework.web.Homework36.repository.OrderRepository;

import java.util.List;

@Component
@Scope("prototype")
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public List<Order> getAllOrders() {
        List<Order> allOrders = orderRepository.getAll();
        if (allOrders == null) {
            throw new RuntimeException();
        }
        return allOrders;
    }

    @Transactional
    public Order getOrderById(int id) {
        Order order = orderRepository.getById(id);
        if (order == null) {
            throw new RuntimeException();
        }
        return order;
    }

    @Transactional
    public void addOrder(Order order) {
        orderRepository.add(order);
    }
}
