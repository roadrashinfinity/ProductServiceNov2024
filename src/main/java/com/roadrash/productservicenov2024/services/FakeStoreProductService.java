package com.roadrash.productservicenov2024.services;

import com.roadrash.productservicenov2024.dto.FakeStoreProductDTO;
import com.roadrash.productservicenov2024.exceptions.ProductNotFoundException;
import com.roadrash.productservicenov2024.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    public RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setPrice(price);

        FakeStoreProductDTO fakeStoreProductDTO1=restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDTO,FakeStoreProductDTO.class);

        return fakeStoreProductDTO1.toProduct();
    }

    @Override
    public Product getSingleProduct(int id) throws ProductNotFoundException{
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity =restTemplate.getForEntity("https://fakestoreapi.com/products/"+id,FakeStoreProductDTO.class);

        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreProductDTOResponseEntity.getBody();

        if(fakeStoreProductDTO==null){
            throw new ProductNotFoundException("Product with id "+id+" is not present");
        }
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOS=restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDTO[].class);

        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO:fakeStoreProductDTOS){
            Product p=fakeStoreProductDTO.toProduct();
            products.add(p);
        }
        return products;
    }
}
