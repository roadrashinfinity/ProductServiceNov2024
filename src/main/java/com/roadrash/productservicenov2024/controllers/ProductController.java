package com.roadrash.productservicenov2024.controllers;

import com.roadrash.productservicenov2024.dto.CreateProductFakeStoreDto;
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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id){
        Product p= productService.getSingleProduct(id);

        if(p==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ResponseEntity<Product> responseEntity=new ResponseEntity<>(p, HttpStatus.OK);
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
