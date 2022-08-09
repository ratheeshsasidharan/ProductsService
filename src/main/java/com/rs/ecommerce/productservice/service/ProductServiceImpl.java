package com.rs.ecommerce.productservice.service;

import com.rs.ecommerce.productservice.exception.ProductNotFoundException;
import com.rs.ecommerce.productservice.model.Product;
import com.rs.ecommerce.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    private ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
