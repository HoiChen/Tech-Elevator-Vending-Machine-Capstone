package com.techelevator.application;

import java.math.BigDecimal;

public abstract class Snack {

    //instance variables
    private String selector;
    private String name;
    private BigDecimal price;
    private String type;
    private String dispenseMessage;
    private int inventoryAmount = 0;


    //constructor for all snack types
    public Snack(String selector, String name, BigDecimal price, String type,
                 String dispenseMessage, int inventoryAmount) {
        this.selector = selector;
        this.name = name;
        this.price = price;
        this.type = type;
        this.dispenseMessage = dispenseMessage;
        this.inventoryAmount = inventoryAmount;
    }

    //getters
    public String getSelector() {
        return selector;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getDispenseMessage() {
        return dispenseMessage;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    //setters
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setInventoryAmount(int newAmount) {
        this.inventoryAmount = newAmount;
    }


    //toString method formats how snack items will print when displayed
    @Override
    public String toString() {
        String result = "\n";
        if (inventoryAmount == 0) {
            result = selector + " | " + name + " | " + "$" + price +
                    " | *** NO LONGER AVAILABLE ***" + '\n' +
                    "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
        } else {
            result = selector + " | " + name + " | " + "$" + price + " | " +
                    "Amount: " + inventoryAmount + '\n' +
                    "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
        }
        return result;
    }

}
