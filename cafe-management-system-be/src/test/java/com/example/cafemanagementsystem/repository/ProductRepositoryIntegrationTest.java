package com.example.cafemanagementsystem.repository;

import com.example.cafemanagementsystem.model.entity.CategoryEntity;
import com.example.cafemanagementsystem.model.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProductRepositoryIntegrationTest {

    private final Integer productId = 1;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        assertEquals(100, products.size());
    }

    @Test
    public void findProduct() {
        final Optional<ProductEntity> productWrapper = productRepository.findById(1);
        assertTrue(productWrapper.isPresent());

        final ProductEntity product = productWrapper.get();
        assertEquals("Espresso", product.getName());
        assertEquals("Strong black coffee", product.getDescription());
        assertEquals(1, product.getCategory().getId());
        assertEquals("Available", product.getStatus());
        assertEquals(3, product.getPrice());
    }

    @Test
    public void findNotExistentProduct() {
        final Optional<ProductEntity> productWrapper = productRepository.findById(-1);
        assertTrue(productWrapper.isEmpty());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void createProduct() {
        ProductEntity product = new ProductEntity();

        final CategoryEntity category = categoryRepository.findById(1).get();

        product.setCategory(category);
        product.setName("Pizza test");
        product.setDescription("Test");
        product.setStatus("Available");
        product.setPrice(10);


        final Integer savedProductId = productRepository.save(product).getId();

        ProductEntity savedProduct = productRepository.findById(savedProductId).get();

        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getDescription(), savedProduct.getDescription());
        assertEquals(product.getCategory(), savedProduct.getCategory());
        assertEquals(product.getStatus(), savedProduct.getStatus());
        assertEquals(product.getPrice(), savedProduct.getPrice());
    }

    @Test
    @DirtiesContext
    public void updateProduct() {
        final Optional<ProductEntity> productWrapper = productRepository.findById(productId);
        assertTrue(productWrapper.isPresent());

        final ProductEntity product = productWrapper.get();

        product.setName("Test name");
        product.setDescription("Test description");

        productRepository.save(product);

        ProductEntity updatedProduct = productRepository.findById(productId).get();
        assertEquals("Test name", updatedProduct.getName());
        assertEquals("Test description", updatedProduct.getDescription());
    }

    @Test
    @DirtiesContext
    public void deleteProduct() {
        assertTrue(productRepository.findById(productId).isPresent());
        productRepository.deleteById(productId);
        assertTrue(productRepository.findById(productId).isEmpty());
    }

}