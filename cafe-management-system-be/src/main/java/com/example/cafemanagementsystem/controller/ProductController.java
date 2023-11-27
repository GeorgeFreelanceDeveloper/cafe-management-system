package com.example.cafemanagementsystem.controller;

import com.example.cafemanagementsystem.constants.CafeConstants;
import com.example.cafemanagementsystem.model.dto.ProductDto;
import com.example.cafemanagementsystem.service.ProductService;
import com.example.cafemanagementsystem.util.CafeUtils;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@NotNull final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Create product")
    ResponseEntity<String> create(@NotNull @Valid @RequestBody final ProductDto productDto) {
        try {
            return productService.create(productDto);
        } catch (Exception ex) {
            log.error("Failed call create", ex);
            return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @Operation(summary = "Get all products")
    ResponseEntity<List<ProductDto>> findAll(@RequestParam(required = false) final Integer categoryId) {
        try {
            return categoryId == null ? productService.findAll() : productService.findByCategoryId(categoryId);
        } catch (Exception ex) {
            log.error("Failed call findAll", ex);
            return new ResponseEntity<>(new ArrayList<ProductDto>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get product by id")
    ResponseEntity<ProductDto> findById(@PathVariable final Integer id) {
        try {
            return productService.findById(id);
        } catch (Exception ex) {
            log.error("Failed call findById", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    @Operation(summary = "Update product")
    ResponseEntity<String> update(@RequestBody final ProductDto productDto) {
        try {
            return productService.update(productDto);
        } catch (Exception ex) {
            log.error("Failed update", ex);
            return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete product")
    ResponseEntity<String> delete(@PathVariable final Integer id) {
        try {
            return productService.delete(id);
        } catch (Exception ex) {
            log.error("Failed call delete", ex);
            return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
