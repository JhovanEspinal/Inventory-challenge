package com.sofka.inventory.domain.product.repository;

import com.sofka.inventory.domain.product.entity.Product;

public interface ProductMutation {
    Product Save(Product product);
    Product Update(Product product);
    void Delete (String productId);
}

