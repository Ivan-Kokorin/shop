package com.example.shop.entities;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "additional_property")
public class AdditionalPropertyEntity {
    @Id
    @Column
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    Long id;

    @Column
    String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    CategoryEntity category;
}
