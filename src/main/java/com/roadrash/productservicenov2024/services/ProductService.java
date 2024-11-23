package com.roadrash.productservicenov2024.services;

import com.roadrash.productservicenov2024.dto.CreateProductFakeStroreDto;
import com.roadrash.productservicenov2024.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product getSingleProduct(int id);

    public Product createProduct(CreateProductFakeStroreDto CreateProductFakeStoreDto);
}
