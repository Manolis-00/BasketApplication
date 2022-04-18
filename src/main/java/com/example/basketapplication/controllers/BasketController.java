package com.example.basketapplication.controllers;

import com.example.basketapplication.models.Basket;
import com.example.basketapplication.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {

    private Basket basket;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productsCount")
    public int getProductCountInCart() {
        return this.basket.getQuantityOfItemsInBasket();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/idCount")
    public int getProductsWIth(String id) {
        return this.basket.getQuantityOfSameProducts(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addToBasket")
    public void addToBasket(@RequestBody Product product) {
        basket.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeFromBasket")
    public void removeFromBasket(@RequestBody Product product) {
        basket.removeProduct(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/emptyBasket")
    public void emptyBasket() {
        basket.emptyList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/totalCost")
    public Double totalCost() {
        return basket.getTotal();
    }
}