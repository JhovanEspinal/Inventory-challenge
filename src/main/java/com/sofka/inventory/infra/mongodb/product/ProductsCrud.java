package com.sofka.inventory.infra.mongodb.product;

import com.sofka.inventory.domain.product.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductsCrud extends MongoRepository<Product, ObjectId> {

    List<Product> findByIdIn(List<String> ids);
}
