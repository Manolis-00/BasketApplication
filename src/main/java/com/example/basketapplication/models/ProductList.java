package com.example.basketapplication.models;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private final ArrayList<Product> products;

    public ProductList() {
        this.products = new ArrayList<>();
        this.products.add(new Product("1", "first product", 1.50, 0.3));
        this.products.add(new Product("2", "second product", 10.50, 0.6));
        this.products.add(new Product("3", "third product", 30.50, 0.9));
        this.products.add(new Product("4", "fourth product", 60.50, 0.1));
        this.products.add(new Product("5", "fifth product", 90.50, 0.4));
        this.products.add(new Product("6", "sixth product", 100.50, 0.7));
    }

    public List<Product> findAll() {
        return this.products;
    }

    public Product find(String id) {
        for (Product product: this.products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

}
