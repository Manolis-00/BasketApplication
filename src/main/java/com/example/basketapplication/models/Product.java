package com.example.basketapplication.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
@Entity
@Table(name = "Products")
 */
public class Product {

    private String id;
    private String name;
    private Double price;
    private Double weight;

    public Product() {
    }

    public Product(String id, String name, double price, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }
}
