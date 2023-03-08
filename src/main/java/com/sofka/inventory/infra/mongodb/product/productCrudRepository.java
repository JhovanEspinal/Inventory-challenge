package com.sofka.inventory.infra.mongodb.product;

import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.repository.ProductRepository;
import com.sofka.inventory.infra.mongodb.ProductsCrud;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class productCrudRepository implements ProductRepository {
    @Autowired
    private ProductsCrud productsCrudRepository;

    public List<Product> GetAll(int pageNumber, int pageSize){
        PageRequest pageable = PageRequest.of(pageNumber,pageSize);
        Page<Product> page = productsCrudRepository.findAll(pageable);
     return page.getContent();
    }

    public Optional<Product> GetById(String productId){
        ObjectId id = new ObjectId(productId);
        return productsCrudRepository.findById(id);
    }

    public Product Save(Product product){
        return productsCrudRepository.save(product);
    }
    public Product Update(Product product){
        return productsCrudRepository.save(product);
    }

    public void Delete (String productId){
        ObjectId id = new ObjectId(productId);
        productsCrudRepository.deleteById(id);
    }








}
