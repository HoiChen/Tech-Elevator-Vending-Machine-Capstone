package com.techelevator.application;

public class PurchaseCounter {

    //variable to reset counter when customer exits
    public static int resetToZero = 0;

    //variables to toggle user discount with the purchase counter
    public static int onePurchase = 1;
    public static int twoPurchases = 2;

    //create purchase counter to keep track of user purchases
    public static int purchaseCounter = 0;

    //setter method for purchase counter
    public static void setPurchaseCounter(int newCounterNum) {
        purchaseCounter = newCounterNum;
    }

    //getter method to display counter number
    public static int getPurchaseCounter() {
        return purchaseCounter;
    }

}
