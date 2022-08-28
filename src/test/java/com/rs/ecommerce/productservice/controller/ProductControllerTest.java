package com.rs.ecommerce.productservice.controller;

import com.rs.ecommerce.productservice.model.Product;
import com.rs.ecommerce.productservice.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    private final List<Product> products= new ArrayList<>();

    @BeforeEach
    public void setup(){
        Product prod = Product.builder().productCode("P100")
                .id("101").tags(Arrays.asList("tag1","tag2")).productName("Iphone 12").build();
        products.add(prod);
        when(productService.findAll()).thenReturn(products);
    }

    public void testFindAll() throws Exception {
        mvc.perform(get("/products/").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productCode", is("P100")));;
    }


}
