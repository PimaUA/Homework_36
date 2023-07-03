package org.springframework.web.Homework36.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.Homework36.entity.Product;
import org.springframework.web.Homework36.repository.ProductRepository;

import java.util.List;

@Component
@Scope("prototype")
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAllProducts() {
        List<Product> productList = null;
        try {
            productList = productRepository.getAll();
        } catch (Exception e) {
            LOGGER.info("No products found: " + e);
        }
        return productList;
    }

    @Transactional
    public Product getProductById(int id) {
        Product product = null;
        try {
            product = productRepository.getById(id);
        } catch (Exception e) {
            LOGGER.info("No such product found: " + e);
        }
        return product;
    }

    @Transactional
    public void addProduct(Product product) {
        try {
            productRepository.add(product);
        } catch (Exception e) {
            LOGGER.info("Product not added: " + e);
        }
    }
}
