package com.example.basketapplication.controllers;

import com.example.basketapplication.models.Item;
import com.example.basketapplication.models.Product;
import com.example.basketapplication.models.ProductList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "basket")
public class BasketController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") String id, HttpSession session) {
        ProductList productList = new ProductList();
        if (session.getAttribute("basket") == null) {
            List<Item> basket = new ArrayList<Item>();
            basket.add(new Item(productList.find(id), 1));
            session.setAttribute("basket", basket);
        } else {
            List<Item> basket = (List<Item>) session.getAttribute("basket");
            /*File isThere = new File("index.html");
            isThere.exists();*/
            basket.add(new Item(productList.find(id), 1));
            int idToInteger = Integer.parseInt(id);
            int quantity = basket.get(idToInteger).getQuantity() + 1;
            basket.get(idToInteger).setQuantity(quantity);
            session.setAttribute("basket", basket);
        }
        return "redirect:index";
    }
}








/*
@Controller
@RequestMapping("/")
public class BasketController {

    @GetMapping("/")
    String index() {
        return "index";
    }
}
 */


