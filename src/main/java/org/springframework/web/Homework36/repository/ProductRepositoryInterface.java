package org.springframework.web.Homework36.repository;

import org.springframework.web.Homework36.entity.Product;

import java.util.List;

public interface ProductRepositoryInterface {

   List<Product> getAll();

    Product getById(int id);

    void add(Product product);
}
