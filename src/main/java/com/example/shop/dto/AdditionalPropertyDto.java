package com.example.shop.dto;

import com.example.shop.entities.PropertyValuePk;
import lombok.Data;

@Data
public class AdditionalPropertyDto {
    Long idProperty;

    String valueProp;
}
