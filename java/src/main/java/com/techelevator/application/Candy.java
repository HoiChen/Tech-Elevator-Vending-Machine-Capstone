package com.techelevator.application;

import java.math.BigDecimal;

public class Candy extends Snack {

    public Candy(String selector, String name, BigDecimal price) {
        super(selector, name, price, "Candy", "Sugar, Sugar, so Sweet!", 6);
    }

}
