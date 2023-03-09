package com.sofka.inventory.domain.buys.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Document(collection = "buys")
public class Buys {
    @Id
    private String id;
    private Date date;
    private String idType;
    private String idClient;
    private String clientName;
    private List<PurchaseProduct> products;
}
