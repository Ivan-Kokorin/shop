package com.example.shop.utils;

import com.example.shop.dto.AdditionalPropertyDto;
import com.example.shop.dto.ProductDto;
import com.example.shop.entities.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectMapper {
    public static ProductEntity toProductEntity(ProductDto productDto) {
//        {
//            "numberSerial" : "id-SSD-12345",
//                "brand" : "WD",
//                "price" : 7300,
//                "amount" : 54,
//                "category" : {
//            "id" : 2
//        },
//            "properties" : [ {
//            "propertyValuePk" : {
//                "idProperty" : {"id" : 1},
//                "idProduct" : {"numberSerial" : "id-SSD-12345"}
//            },
//            "valueProp" : "512 Gb"
//        } ]
//        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setNumberSerial(productDto.getNumberSerial());
        productEntity.setBrand(productDto.getBrand());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setAmount(productDto.getAmount());

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(productDto.getIdCategory());
        productEntity.setCategory(categoryEntity);

        ArrayList<PropertyValueEntity> propertyValueEntities = new ArrayList<>();
        List<AdditionalPropertyDto> propertiesDto = productDto.getProperties();
        for (AdditionalPropertyDto propertyDto : propertiesDto) {
            PropertyValueEntity propertyValue = new PropertyValueEntity();
            propertyValue.setValueProp(propertyDto.getValueProp());
            PropertyValuePk propertyValuePk = new PropertyValuePk();
            AdditionalPropertyEntity additionalPropertyEntity = new AdditionalPropertyEntity();
            additionalPropertyEntity.setId(propertyDto.getIdProperty());
            additionalPropertyEntity.setCategory(categoryEntity);
            propertyValuePk.setIdProperty(additionalPropertyEntity);
            propertyValuePk.setIdProduct(productEntity);
            propertyValue.setPropertyValuePk(propertyValuePk);
            propertyValueEntities.add(propertyValue);
        }
        productEntity.setProperties(propertyValueEntities);
        System.out.println("Product entity :" + productEntity);
        return productEntity;
    }
}
