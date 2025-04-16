package com.techpro.productservice.repository;

import com.techpro.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom method to find product by name
    Optional<Product> findByName(String name);
}