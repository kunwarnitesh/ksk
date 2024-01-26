package com.ksk.nosql.repo;

import com.ksk.nosql.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
