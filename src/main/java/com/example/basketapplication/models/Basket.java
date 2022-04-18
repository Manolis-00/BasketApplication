package com.example.basketapplication.models;

import java.util.ArrayList;

public class Basket {

    private final ArrayList<Product> productList;

    public Basket(ProductList productList) {
        this.productList = new ArrayList<>();
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

        Double partialCost = sumOfPrice();

        Double  totalWeightCost = sumOfWeightCost();

        Double totalCost = partialCost + totalWeightCost;

        return isDiscountEnabled(totalCost)
                ? getTotalWithDiscount(totalCost)
                : totalCost;
    }

    public Double sumOfPrice() {

        return productList
                .stream()
                .map(Product::getPrice)
                .reduce(0.00, Double::sum);
    }

    public Double sumOfWeightCost() {
        double totalWeightCost = productList
                .stream()
                .map(Product::getWeight)
                .reduce(0.00, Double::sum);
        totalWeightCost = totalWeightCost * 5;

        return totalWeightCost;
    }

    public boolean isDiscountEnabled(Double totalCost) {
        return totalCost > 100.00;
    }

    public Double calculateDiscount(Double totalCost) {
        Double discount = 0.1;
        return totalCost * discount;
    }

    public Double getTotalWithDiscount(Double totalCost) {
        return totalCost - calculateDiscount(totalCost);
    }

    public int getQuantityOfItemsInBasket() {
        int i = 0;
        while (productList.iterator().hasNext()) {
            i++;
        }
        return i;
    }

    public int getQuantityOfSameProducts(String id) {
        int counter = 0;
        for(Product product : productList){
            if (id == product.getId()) {
                counter++;
            }
        }
        return counter;
    }

}
