package com.techelevator.application;

import java.math.BigDecimal;

public class Drink extends Snack {

    public Drink(String selector, String name, BigDecimal price) {
        super(selector, name, price, "Drink", "Drinky, Drinky, Slurp Slurp!", 6);
    }

}
