package com.ksk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private String brand;
    private double price;
    private boolean available;
    private String sku;
    private String[] features;
    private String specifications;
    private double averageRating;
    private int numberOfReviews;
    private String warrantyInformation;
    private String[] images;
    private String releaseDate;
    private String compatibility;
    private String[] variants;
}
