package com.sofka.inventory.domain.buys.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BuysSummary {
    @Id
    private String id;
    private Date date;
    private String idType;
    private String idClient;
    private String clientName;

    private List<String> successfulProducts;
    private List<String> ErrorProducts;
}

