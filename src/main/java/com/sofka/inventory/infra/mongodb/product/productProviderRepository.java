package com.sofka.inventory.infra.mongodb.product;

import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.repository.ProductProvider;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class productProviderRepository implements ProductProvider {

    @Autowired
    private ProductsCrud productsCrud;
    public List<Product> GetAll(int pageNumber, int pageSize){
        PageRequest pageable = PageRequest.of(pageNumber,pageSize);
        Page<Product> page = productsCrud.findAll(pageable);
        return page.getContent();
    }

    public Optional<Product> GetById(String productId){
        ObjectId id = new ObjectId(productId);
        return productsCrud.findById(id);
    }

    @Override
    public List<Product> GetAllByIds(List<String> ids) {
       return productsCrud.findByIdIn(ids);
    }



}
