package com.roadrash.productservicenov2024.dto;

import com.roadrash.productservicenov2024.models.Category;
import com.roadrash.productservicenov2024.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDTO {

    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct() {
        Product product = new Product();

        product.setName(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category category1=new Category();
        category1.setTitle(category);

        product.setCategory(category1);
        return product;

    }

}
