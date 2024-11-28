package com.roadrash.productservicenov2024.repositories;

import com.roadrash.productservicenov2024.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface categoryRepository extends JpaRepository<Category,Long> {
    Category findByTitle(String title);

    Optional<Category> findById(Long Id);
}
