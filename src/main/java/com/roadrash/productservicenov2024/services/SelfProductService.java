package com.roadrash.productservicenov2024.services;

import com.roadrash.productservicenov2024.exceptions.ProductNotFoundException;
import com.roadrash.productservicenov2024.models.Category;
import com.roadrash.productservicenov2024.models.Product;
import com.roadrash.productservicenov2024.repositories.ProductRepository;
import com.roadrash.productservicenov2024.repositories.categoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Service("selfProductService")
public class SelfProductService implements ProductService{

    private categoryRepository categoryRepository;

    private ProductRepository productRepository;

    public SelfProductService(categoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        Product p=new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setImageUrl(image);

        p.setPrice(price);
        Date date=new Date();
        p.setCreated_at(date);
        p.setUpdated_at(date);
        p.setDeleted(false);

        Category category1= categoryRepository.findByTitle(category);

        if(category1==null){
            Category category2=new Category();
            category2.setTitle(category);
            category1=category2;
        }
        p.setCategory(category1);

        Product addedProduct=productRepository.save(p);

        return addedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(int id) throws ProductNotFoundException {
        return null;
    }
}
