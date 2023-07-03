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
        return orderRepository.getAll();
    }

    @Transactional
    public Order getOrderById(int id) {
      return orderRepository.getById(id);
    }

    @Transactional
    public void addOrder(Order order) {
        orderRepository.add(order);
    }
}
