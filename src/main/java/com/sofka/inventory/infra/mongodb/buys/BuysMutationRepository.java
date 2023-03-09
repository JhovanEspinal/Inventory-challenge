package com.sofka.inventory.infra.mongodb.buys;

import com.sofka.inventory.domain.buys.entity.Buys;
import com.sofka.inventory.domain.buys.repository.BuysMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuysMutationRepository implements BuysMutation {
    @Autowired
    private BuysCrud buysCrud;

    public Buys Save(Buys buys) {
        return buysCrud.save(buys);
    }
}
