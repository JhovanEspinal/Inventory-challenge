package com.sofka.inventory.infra.mongodb.buys;

import com.sofka.inventory.domain.buys.entity.Buys;
import com.sofka.inventory.domain.buys.repository.BuysMutation;
import com.sofka.inventory.domain.buys.repository.BuysProvider;
import com.sofka.inventory.domain.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuysProviderRepository implements BuysProvider {
    @Autowired
    private BuysCrud buysCrud;

    public List<Buys> GetAll(int pageNumber, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber,pageSize);
        Page<Buys> page = buysCrud.findAll(pageable);
        return page.getContent();
    }
}
