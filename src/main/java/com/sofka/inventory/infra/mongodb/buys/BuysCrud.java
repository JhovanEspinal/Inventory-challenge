package com.sofka.inventory.infra.mongodb.buys;

import com.sofka.inventory.domain.buys.entity.Buys;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuysCrud extends MongoRepository<Buys, ObjectId> {
}
