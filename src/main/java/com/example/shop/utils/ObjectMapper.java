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
//            "numberSerial" : "id-NoteBook-66611",
//                "brand" : "Asus",
//                "price" : 90000,
//                "amount" : 18,
//                "idCategory" : 7,
//                "properties" : [ {
//            "idProperty" : 6,
//                    "valueProp" : "17'"
//        }, {
//            "idProperty" : 7,
//                    "valueProp" : "sensor"
//        },{
//            "idProperty" : 5,
//                    "valueProp" : "GPU"
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
        return productEntity;
    }

    public static ProductDto toProductDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.setNumberSerial(productEntity.getNumberSerial());
        productDto.setBrand(productEntity.getBrand());
        productDto.setPrice(productEntity.getPrice());
        productDto.setAmount(productEntity.getAmount());
        productDto.setIdCategory(productEntity.getCategory().getId());

        ArrayList<AdditionalPropertyDto> additionalPropertyDtos = new ArrayList<>();
        List<PropertyValueEntity> properties = productEntity.getProperties();
        for (PropertyValueEntity propertyEntity : properties) {
            AdditionalPropertyDto propertyDto = new AdditionalPropertyDto();
            propertyDto.setValueProp(propertyEntity.getValueProp());
            propertyDto.setIdProperty(propertyEntity.getPropertyValuePk().getIdProperty().getId());
            additionalPropertyDtos.add(propertyDto);
        }
        productDto.setProperties(additionalPropertyDtos);
        return productDto;
    }
}
