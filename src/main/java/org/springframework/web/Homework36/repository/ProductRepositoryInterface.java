package org.springframework.web.Homework36.repository;

import org.springframework.web.Homework36.entity.Product;

import java.util.List;

public interface ProductRepositoryInterface {

    public List<Product> getAll();

    public Product getById(int id);

    public void add(Product product);
}
