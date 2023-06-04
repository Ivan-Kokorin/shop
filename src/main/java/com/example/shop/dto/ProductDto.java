package com.example.shop.dto;

import lombok.Data;

@Data
public class ProductDto {
    Long id;

    String number_serial;

    String brand;

    int price;
    int amount;

    CategoryDto category;
}
