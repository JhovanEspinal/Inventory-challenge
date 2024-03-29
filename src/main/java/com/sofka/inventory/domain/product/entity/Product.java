package com.sofka.inventory.domain.product.entity;

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
        private String id;
        private String name;
        private int inInventory;
        private boolean enabled;
        private int min;
        private int max;
        private double price;

}
