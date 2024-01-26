package com.ksk.nosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product")
@Data
@AllArgsConstructor
public class Product {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;

}
