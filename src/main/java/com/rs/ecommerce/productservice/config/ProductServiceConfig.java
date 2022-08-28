package com.rs.ecommerce.productservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("product-service")
@Component
public class ProductServiceConfig {
    private int maxPageSize;
}
