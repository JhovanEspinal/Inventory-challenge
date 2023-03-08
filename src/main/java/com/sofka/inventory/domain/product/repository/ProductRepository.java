package com.sofka.inventory.domain.product.repository;

import com.sofka.inventory.domain.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> GetAll(int pageNumber, int pageSize);
    Optional<Product> GetById(String product);
    Product Save(Product product);
    Product Update(Product product);
    void Delete (String productId);
}
