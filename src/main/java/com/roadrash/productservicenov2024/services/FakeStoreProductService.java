package com.roadrash.productservicenov2024.services;

import com.roadrash.productservicenov2024.dto.CreateProductFakeStroreDto;
import com.roadrash.productservicenov2024.dto.FakeStoreProductDTO;
import com.roadrash.productservicenov2024.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    public RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(CreateProductFakeStroreDto CreateProductFakeStoreDto) {
        return null;
    }

    @Override
    public Product getSingleProduct(int id) {
        FakeStoreProductDTO fakeStoreProductDTO =restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
