package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "property_value")
public class PropertyValueEntity {
    @EmbeddedId
    PropertyValuePk propertyValuePk;

    String valueProp;

}
