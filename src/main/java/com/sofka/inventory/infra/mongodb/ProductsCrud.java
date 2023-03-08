package com.sofka.inventory.infra.mongodb;

import com.sofka.inventory.domain.product.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsCrud extends MongoRepository<Product, ObjectId> {
}
