package com.rs.ecommerce.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String id;
    @NotNull(message = "Product Code cannot be blank")
    private String productCode;
    @Min(value = 1, message = "Product price should be greater than zero")
    private double productPrice;
    @NotNull(message = "Product name cannot be blank")
    private String productName;
    boolean inStock;
    private List<String> relatedProducts;
    private List<String> tags;
}
