package com.example.basketapplication;

import com.example.basketapplication.models.Basket;
import com.example.basketapplication.models.Product;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasketTest {

    public  Basket basket;

    @Before
    public void setup() {
        basket.addProduct(new Product("1", "first product", 1.50, 0.3));
        basket.addProduct(new Product("2", "second product", 10.50, 0.6));
        basket.addProduct(new Product("3", "third product", 30.50, 0.9));
        basket.addProduct(new Product("4", "fourth product", 60.50, 0.1));
        basket.addProduct(new Product("5", "fifth product", 90.50, 0.4));
        basket.addProduct(new Product("6", "sixth product", 100.50, 0.7));
    }

    @Test
    public void shouldGetQuantityOfItemsInBasket() {
        int expectedResult = 6;
        int result = basket.getQuantityOfItemsInBasket();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldGetQuantityOfSameProducts(String id) {
        int expectedResult = 1;
        int result = basket.getQuantityOfSameProducts("1");

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldCalculateSumOfPrice() {
        double expectedResult = 294.00;
        double result = basket.sumOfPrice();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldCalculateSumOfWeightCost() {
        double expectedResult = 15.00;
        double result = basket.sumOfWeightCost();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldCalculateTotalWithDiscount() {
        double expectedResult = 278.1;
        double result = basket.getTotalWithDiscount(309.00);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldGetTotal() {
        double expextedResult = 278.1;
        double result = basket.getTotal();

        Assertions.assertEquals(expextedResult, result);
    }

    @Test
    public void shouldCheckIfDiscountIsApplied() {
        boolean expectedResult = true;
        double totalCost = 101.00;
        boolean result = basket.isDiscountEnabled(totalCost);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldCalculateDiscount() {
        double expectedResult = 10.00;
        double value = 100.00;
        double result = basket.calculateDiscount(value);

        Assertions.assertEquals(expectedResult, result);
    }

}
