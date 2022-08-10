package com.rs.ecommerce.productservice.service;

import com.rs.ecommerce.productservice.model.Product;
import com.rs.ecommerce.productservice.model.ProductDto;
import com.rs.ecommerce.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    private final List<Product> products= new ArrayList<>();

    @BeforeEach
    public void setup(){
        Product prod = Product.builder().productCode("P100")
                .id("101").tags(Arrays.asList("tag1","tag2")).productName("Iphone 12").build();
        products.add(prod);
        when(productRepository.findAll()).thenReturn(products);
    }

    @Test
    public void testFindAll(){
        List<Product> productsOut=productService.findAll();
        Assertions.assertEquals(productsOut,products);
    }







}
