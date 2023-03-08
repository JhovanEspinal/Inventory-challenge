package com.sofka.inventory.persistence.crud;

import com.sofka.inventory.persistence.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductsCrudRepository extends MongoRepository<Product, ObjectId> {
}
