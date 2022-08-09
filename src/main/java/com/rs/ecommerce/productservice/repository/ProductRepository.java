package com.rs.ecommerce.productservice.repository;

import com.rs.ecommerce.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByProductCode(String productCode);
    Product findByProductName(String productName);
}
