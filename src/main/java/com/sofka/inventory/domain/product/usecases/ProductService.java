package com.sofka.inventory.domain.product.usecases;

import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> GetAll(int pageNumber, int size){
        return productRepository.GetAll(pageNumber, size);
    }

    public Optional<Product> GetById(String productId){
        return productRepository.GetById(productId);
    }

    public Product Save(Product product){
        return productRepository.Save(product);
    }

    public Product Update(Product product){
        return productRepository.Update(product);
    }

    public boolean Delete(String productId){
      return productRepository.GetById(productId).map(product -> {
          productRepository.Delete(productId);
      return true;
      }).orElse(false);
    }


}
