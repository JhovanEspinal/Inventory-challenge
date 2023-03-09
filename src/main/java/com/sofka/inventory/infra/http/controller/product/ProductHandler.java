package com.sofka.inventory.infra.http.controller.product;

import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.usecase.ProductUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductHandler {
    @Autowired
    private ProductUseCases useCases;

    @GetMapping("/{pageNumber}/{size}")
    public ResponseEntity<List<Product>> GetAll(@PathVariable("pageNumber")int pageNumber, @PathVariable("size")int size){
        return new ResponseEntity<>(useCases.GetAll(pageNumber,size), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> GetById(@PathVariable("id") String productId){
        return useCases.GetById(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND ));
    }

    @PostMapping()
    public ResponseEntity<Product> Save(@RequestBody Product product){
        return new ResponseEntity<>(useCases.Save(product),HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Product> Update(@RequestBody Product product){


        return new ResponseEntity<>(useCases.Update(product),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity Delete(@PathVariable("id") String productId){

        if(useCases.Delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
