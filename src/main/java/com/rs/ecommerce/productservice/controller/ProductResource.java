package com.rs.ecommerce.productservice.controller;

import com.rs.ecommerce.productservice.model.Product;
import com.rs.ecommerce.productservice.model.ProductDto;
import com.rs.ecommerce.productservice.service.ProductService;
import com.rs.ecommerce.productservice.util.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {
    private ProductService productService;

    ProductResource(ProductService productService){
        this.productService=productService;
    }

    @GetMapping(value = "/")
    public List<ProductDto> getAllProducts(){
        return ObjectMapper.mapAll(productService.findAll(), ProductDto.class);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto productDto){
        productDto.setId(null);
        Product product = productService.saveOrUpdateProduct(ObjectMapper.map(productDto,Product.class));
        return new ResponseEntity<>(ObjectMapper.map(product,ProductDto.class), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ProductDto getProductById(@PathVariable("id") String id ){
        return ObjectMapper.map(productService.findById(id), ProductDto.class);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto,@PathVariable("id") String id){
        productDto.setId(id);
        Product product = productService.saveOrUpdateProduct(ObjectMapper.map(productDto,Product.class));
        return new ResponseEntity<>(ObjectMapper.map(product,ProductDto.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") String id ){
        productService.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

}
