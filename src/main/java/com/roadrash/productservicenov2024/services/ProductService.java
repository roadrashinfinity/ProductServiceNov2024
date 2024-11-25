package com.roadrash.productservicenov2024.services;

import com.roadrash.productservicenov2024.exceptions.ProductNotFoundException;
import com.roadrash.productservicenov2024.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product getSingleProduct(int id) throws ProductNotFoundException;

    public Product createProduct(String title,String description,String image,String category,double price );
}
