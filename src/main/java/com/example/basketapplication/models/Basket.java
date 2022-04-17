package com.example.basketapplication.models;

import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private Double totalCost;
    Product product = new Product();
    private ProductList list;
    private ArrayList<Product> productList;

    //private Vector productList;

    public Basket(ProductList productList) {

        totalCost = 0.0;
        this.productList = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void  removeProduct(Product product) {
        productList.remove(product);
    }

    public void emptyList() {
        productList.clear();
    }

    public Double getTotal() {
        for (int i = 0; i < productList.size(); i++) {
            totalCost = totalCost + product.getPrice();
        }

        return isDiscountEnabled(totalCost)
                ? getTotalWithDiscount(totalCost)
                : totalCost;
    }

    private boolean isDiscountEnabled(Double totalCost) {
        return totalCost > 100.00;
    }

    private Double calculateDiscount(Double totalCost) {
        Double discount = 0.1;
        return totalCost * discount;
    }

    private Double getTotalWithDiscount(Double totalCost) {
        return totalCost - calculateDiscount(totalCost);
    }

}
