package com.sofka.inventory.domain.product.repository;

import com.sofka.inventory.domain.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductProvider {
    List<Product> GetAll(int pageNumber, int pageSize);
    Optional<Product> GetById(String product);

    List<Product> GetAllByIds(List<String> ids);
}
