package com.techpro.productservice.service;

import com.techpro.productservice.model.Product;
import com.techpro.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class handles business logic related to Product resources.
 * It interacts with the ProductRepository to perform CRUD operations.
 */

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieve all products in the system.
     * @return List of all products.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieve a single product by its ID.
     * @param id ID of the product to retrieve
     * @return Product object if found, or null if not found.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Add a new product to the system.
     * @param product Product object to be created
     * @return Created Product object with assigned ID
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Update an existing product using its ID.
     * @param id ID of the product to update
     * @param product Updated product data (name, price)
     * @return Updated product object
     */
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Delete a product by its ID.
     * @param id ID of the product to delete
     */
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }
    /**
     * Find a product by its name.
     * @param name Name of the product to find
     * @return Product object if found, or null if not found.
     */
    public Product findProductByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }
}
