package com.sofka.inventory.domain.product.usecase;

import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.repository.ProductMutation;
import com.sofka.inventory.domain.product.repository.ProductProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductUseCases {
    @Autowired
    private ProductProvider productProvider;
     @Autowired
    private ProductMutation mutations;

    public List<Product> GetAll(int pageNumber, int size){
        return productProvider.GetAll(pageNumber, size);
    }

    public Optional<Product> GetById(String productId){
        return productProvider.GetById(productId);
    }

    public Product Save(Product product){
        return mutations.Save(product);
    }

    public Product Update(Product product){
        return mutations.Update(product);
    }

    public boolean Delete(String productId){
      return productProvider.GetById(productId).map(product -> {
          mutations.Delete(productId);
      return true;
      }).orElse(false);
    }


}
