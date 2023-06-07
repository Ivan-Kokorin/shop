package com.example.shop.controllers;

import com.example.shop.dto.ProductDto;
import com.example.shop.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @Autowired

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @PutMapping(value = "/{productId}")
    public String updateProduct(@RequestBody ProductDto productDto, @PathVariable String productId) {
        productDto.setNumberSerial(productId);
        return productService.update(productDto);
    }

    @GetMapping
    public List<ProductDto> getProductsByCategory(@RequestParam Long categoryId) {
        return productService.getAllProductCategory(categoryId);
    }

    @GetMapping(value = "/{productId}")
    public ProductDto getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(MyResourceNotFoundException.class)
    public Response handleResourceException(MyResourceNotFoundException e) {
        return new Response(e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MyInternalServerException.class)
    public Response handleServerException(MyInternalServerException e) {
        return new Response(e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
    public Response handleSqlException(JdbcSQLIntegrityConstraintViolationException e) {
        return new Response(e.getMessage());
    }
}
