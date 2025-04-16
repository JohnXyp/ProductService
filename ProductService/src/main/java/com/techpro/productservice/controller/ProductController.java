package com.techpro.productservice.controller;

import com.techpro.productservice.model.Product;
import com.techpro.productservice.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller handles all HTTP requests related to Product resources.
 * It uses a service layer to separate business logic from request handling.
 */
@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Product Management API")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint: Get all products (returns JSON)
    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieves a list of all available products")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products retrieved successfully")
    })
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Endpoint: Get product by ID (returns JSON)
    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Fetch a single product by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Endpoint: Add a new product
    @PostMapping
    @Operation(summary = "Create a product", description = "Add a new product to the catalog")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Product created"),
        @ApiResponse(responseCode = "400", description = "Invalid data")
    })
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Endpoint: Update an existing product by ID
    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Update details of an existing product")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product updated"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.saveProduct(product);
    }

    // Endpoint: Delete a product by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Remove a product by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product deleted"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}