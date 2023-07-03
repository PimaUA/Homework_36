package org.springframework.web.Homework36.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.Homework36.entity.Order;
import org.springframework.web.Homework36.exception_handling.OrderIncorrectData;
import org.springframework.web.Homework36.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<Order> showAllOrders() {
        List<Order> orderList;
        try {
            orderList = orderService.getAllOrders();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No orders available ", e);
        }
        return orderList;
    }

    @GetMapping("/orders/{id}")
    public Order showOrderById(@PathVariable int id) {
        Order order;
        try {
            order = orderService.getOrderById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found ", e);
        }
        return order;
    }

    @PostMapping("/orders")
    public Order showAddedOrder(@RequestBody Order order) {
        try {
            orderService.addOrder(order);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not added ", e);
        }
        return order;
    }

    @ExceptionHandler
    public ResponseEntity<OrderIncorrectData> handleException(Exception exception) {
        OrderIncorrectData orderIncorrectData = new OrderIncorrectData();
        orderIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(orderIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
