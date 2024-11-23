package com.roadrash.productservicenov2024.controllers;

import com.roadrash.productservicenov2024.dto.CreateProductFakeStroreDto;
import com.roadrash.productservicenov2024.models.Product;
import com.roadrash.productservicenov2024.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //Single Product
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") int id){
        return productService.getSingleProduct(id);
    }

    //createProduct
    @PostMapping("/prouducs")
    public Product createProduct(@RequestBody CreateProductFakeStroreDto CreateProductFakeStroreDto){
        return productService.createProduct(CreateProductFakeStroreDto);
    }
}
