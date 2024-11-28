package com.roadrash.productservicenov2024.repositories;

import com.roadrash.productservicenov2024.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
}
