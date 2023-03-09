package com.sofka.inventory.infra.mongodb.product;

import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.repository.ProductMutation;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductMutationRepository implements ProductMutation {
    @Autowired
    private ProductsCrud productsCrud;

    public Product Save(Product product){
        return productsCrud.save(product);
    }
    public Product Update(Product product){
        return productsCrud.save(product);
    }

    public void Delete (String productId){
        ObjectId id = new ObjectId(productId);
        productsCrud.deleteById(id);
    }








}
