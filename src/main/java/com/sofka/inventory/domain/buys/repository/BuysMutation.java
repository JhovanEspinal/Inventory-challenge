package com.sofka.inventory.domain.buys.repository;

import com.sofka.inventory.domain.buys.entity.Buys;

public interface BuysMutation {
    Buys Save(Buys buys);
}
