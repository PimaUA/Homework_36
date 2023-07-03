package org.springframework.web.Homework36.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    private int id;
    @Column
    @Getter
    private LocalDate date;
    @Column
    @Getter
    private double cost;
    @ManyToMany(mappedBy = "listOfOrders")
    private List<Product> listOfProducts;
}
