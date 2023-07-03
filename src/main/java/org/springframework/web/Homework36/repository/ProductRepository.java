package org.springframework.web.Homework36.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.Homework36.entity.Product;

import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInterface{
@Autowired
private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        Query query=entityManager.createQuery("From Product");
        return query.getResultList();
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void add(Product product) {
        entityManager.merge(product);
    }
}
