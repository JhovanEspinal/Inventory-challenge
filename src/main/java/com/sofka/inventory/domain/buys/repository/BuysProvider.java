package com.sofka.inventory.domain.buys.repository;

import com.sofka.inventory.domain.buys.entity.Buys;

import java.util.List;

public interface BuysProvider {
    List<Buys> GetAll(int pageNumber, int pageSize);
}
