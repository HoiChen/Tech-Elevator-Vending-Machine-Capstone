package com.techelevator.application;

import java.math.BigDecimal;

public class Money {

    //public money instance variables to use with any money methods
    public static final BigDecimal dollar = new BigDecimal("1.00");
    public static final BigDecimal quarter = new BigDecimal("0.25");
    public static final BigDecimal dime = new BigDecimal("0.10");
    public static final BigDecimal nickel = new BigDecimal("0.05");
    public static final BigDecimal zero = new BigDecimal("0.00");

    //instance variable holding customer's money amount
    private static BigDecimal customerMoney = new BigDecimal("0.00");

    //getter to pull customer's money amount
    public static BigDecimal getCustomerMoney() {
        return customerMoney;
    }

    //setter to clear out customer's account at end
    public static void setCustomerMoney(BigDecimal newAmount) {
         customerMoney = newAmount;
    }

    //setter to add money to customer amount
    public static void addCustomerMoney(BigDecimal newAmount) {
         customerMoney = customerMoney.add(newAmount);
    }

    //method to return change with smallest amount of coins
    public static String returnChange() {

        int dollarsReturned = 0;
        int quartersReturned = 0;
        int dimesReturned = 0;
        int nickelsReturned = 0;

        BigDecimal totalAmountToReturn = customerMoney;

        while (totalAmountToReturn.compareTo(zero) > 0) {
            if (totalAmountToReturn.compareTo(dollar) >= 0) {
                totalAmountToReturn = totalAmountToReturn.subtract(dollar);
                dollarsReturned++;
            } else if (totalAmountToReturn.compareTo(quarter) >= 0) {
                totalAmountToReturn = totalAmountToReturn.subtract(quarter);
                quartersReturned++;
            } else if (totalAmountToReturn.compareTo(dime) >= 0) {
                totalAmountToReturn = totalAmountToReturn.subtract(dime);
                dimesReturned++;
            } else {
                totalAmountToReturn = totalAmountToReturn.subtract(nickel);
                nickelsReturned++;
            }
        }

        setCustomerMoney(zero);

        return "Your change is: " + dollarsReturned + " dollar(s), " +
                quartersReturned + " quarter(s), " + dimesReturned +
                " dime(s), and " + nickelsReturned + " nickel(s).";
    }

}
