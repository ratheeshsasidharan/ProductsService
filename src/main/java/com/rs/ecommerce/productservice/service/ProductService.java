package com.rs.ecommerce.productservice.service;

import com.rs.ecommerce.productservice.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product saveOrUpdateProduct(Product product);

    Product findById(String id);

    void deleteById(String id);

}
