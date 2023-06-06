package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PropertyValuePk implements Serializable {
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="id_property")
    AdditionalPropertyEntity idProperty;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="number_serial")
    ProductEntity idProduct;

    @Override
    public String toString() {
        return "PropertyValuePk{" +
                "idProperty=" + idProperty.getId() +
                ", idProduct=" + idProduct.getNumberSerial() +
                '}';
    }
}
