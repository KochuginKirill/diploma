package com.example.bysell.models;

import lombok.Data;

@Data
public class ProductDTO {
    private String title;
    private int price;
    private String city;

    public ProductDTO(String title, int price, String city) {
        this.title = title;
        this.price = price;
        this.city = city;
    }
}
