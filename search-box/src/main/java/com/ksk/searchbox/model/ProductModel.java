package com.ksk.searchbox.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Data
public class ProductModel {

    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;
}
