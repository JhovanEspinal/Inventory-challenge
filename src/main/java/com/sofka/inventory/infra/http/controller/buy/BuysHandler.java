package com.sofka.inventory.infra.http.controller.buy;

import com.sofka.inventory.domain.buys.dtos.BuysSummary;
import com.sofka.inventory.domain.buys.entity.Buys;
import com.sofka.inventory.domain.buys.usecase.BuysUseCases;
import com.sofka.inventory.domain.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buys")
public class BuysHandler {

    @Autowired
    private BuysUseCases buysUseCases;

    @GetMapping("/{pageNumber}/{size}")
    public ResponseEntity<List<Buys>> GetAll(@PathVariable("pageNumber")int pageNumber, @PathVariable("size")int size){
        return new ResponseEntity<>(buysUseCases.GetAll(pageNumber,size), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<BuysSummary> Save(@RequestBody Buys buys){
        return new ResponseEntity<>(buysUseCases.Save(buys), HttpStatus.OK);
    }
}
