package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class ProductEntity {
    @Id
    @Column
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    Long id;

    @Column
    String number_serial;

    @Column
    String brand;

    @Column
    int price;
    @Column
    int amount;
    @OneToOne
    @PrimaryKeyJoinColumn
    CategoryEntity category;
}
