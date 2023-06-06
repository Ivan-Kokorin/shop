package com.example.shop.controllers;

import com.example.shop.dto.ProductDto;
import com.example.shop.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("Get prod :" + productDto);
        ProductDto saveProd = productService.save(productDto);
        System.out.println("Save prod :" + saveProd);
//        if (saveProd.getId() != null) {
//            return RequestStatus.OK.getStatus();
//        }
        return RequestStatus.OK.getStatus();
    }

    @PutMapping(value = "/{id}")
    public String updateProduct(@RequestBody ProductDto productDto) {
        ProductDto saveProd = productService.save(productDto);
        return RequestStatus.OK.getStatus();
    }
}
