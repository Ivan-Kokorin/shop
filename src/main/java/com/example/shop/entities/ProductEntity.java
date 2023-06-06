package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    String numberSerial;

    @Column
    String brand;

    @Column
    int price;
    @Column
    int amount;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    CategoryEntity category;

    @OneToMany(mappedBy = "propertyValuePk.idProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PropertyValueEntity> properties;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "numberSerial='" + numberSerial + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", category=" + category.getId() + " " + category.getTitle() +
                ", properties=" + properties +
                '}';
    }
}
