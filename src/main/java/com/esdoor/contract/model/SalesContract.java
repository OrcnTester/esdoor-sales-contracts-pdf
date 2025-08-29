package com.esdoor.contract.model;

import lombok.Data;
import java.util.List;

@Data
public class SalesContract {
    private String buyerName;
    private String address;
    private List<Item> items;
    private String iban;

    @Data
    public static class Item {
        private String name;
        private int qty;
        private double price;
    }
}
