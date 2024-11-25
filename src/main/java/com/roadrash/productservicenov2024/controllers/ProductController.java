package com.roadrash.productservicenov2024.controllers;

import com.roadrash.productservicenov2024.dto.CreateProductFakeStoreDto;
import com.roadrash.productservicenov2024.dto.ErrorDTO;
import com.roadrash.productservicenov2024.exceptions.ProductNotFoundException;
import com.roadrash.productservicenov2024.models.Product;
import com.roadrash.productservicenov2024.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Product p= productService.getSingleProduct(id);
        ResponseEntity<Product> responseEntity;
        if(p == null){
            responseEntity = new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        }else{
            responseEntity = new ResponseEntity<>(p, HttpStatus.OK);
        }

        return responseEntity;
    }

    //createProduct
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductFakeStoreDto CreateProductFakeStoreDto){
        return productService.createProduct(CreateProductFakeStoreDto.getTitle(),
                CreateProductFakeStoreDto.getDescription(),
                CreateProductFakeStoreDto.getImage(),
                CreateProductFakeStoreDto.getCategory(),
                CreateProductFakeStoreDto.getPrice());

    }



}
