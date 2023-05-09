package com.example.model;
import jakarta.persistence.*;

import java.util.List;


@Entity(name = "product")
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String descriptions;

    private Float price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> cartList;

    public Long getId() {
        return id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescription(String descriptions) {
        this.descriptions = descriptions;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }
}
