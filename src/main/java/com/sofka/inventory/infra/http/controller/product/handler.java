package com.sofka.inventory.infra.http.controller.product;

import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.usecases.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class handler {
    @Autowired
    private ProductService productService;

    @GetMapping("/{pageNumber}/{size}")
    public ResponseEntity<List<Product>> GetAll(@PathVariable("pageNumber")int pageNumber, @PathVariable("size")int size){
        return new ResponseEntity<>(productService.GetAll(pageNumber,size), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> GetById(@PathVariable("id") String productId){
        return productService.GetById(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND ));
    }

    @PostMapping()
    public ResponseEntity<Product> Save(@RequestBody Product product){
        return new ResponseEntity<>(productService.Save(product),HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Product> Update(@RequestBody Product product){


        return new ResponseEntity<>(productService.Update(product),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity Delete(@PathVariable("id") String productId){

        if(productService.Delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
