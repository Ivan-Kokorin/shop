package com.example.shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    String numberSerial;

    String brand;

    int price;
    int amount;

    Long idCategory;

    List<AdditionalPropertyDto> properties;
}
