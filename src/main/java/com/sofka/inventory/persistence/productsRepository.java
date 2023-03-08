package com.sofka.inventory.persistence;

import com.sofka.inventory.persistence.crud.ProductsCrudRepository;
import com.sofka.inventory.persistence.entity.Product;

import java.util.List;

public class productsRepository {
    private ProductsCrudRepository productsCrudRepository;

    public List<Product> getAll(){
     return productsCrudRepository.findAll();
    }


}
