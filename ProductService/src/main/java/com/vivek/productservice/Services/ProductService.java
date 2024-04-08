package com.vivek.productservice.Services;

import com.vivek.productservice.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
