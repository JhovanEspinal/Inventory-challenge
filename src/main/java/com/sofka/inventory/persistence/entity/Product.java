package com.sofka.inventory.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "products")
public class Product {
    @Id
    private ObjectId id;
    private String   name;
    private int inInventory;
    private boolean enabled;
    private int min;
    private int max;



}