package com.techelevator.ui;

import com.techelevator.application.*;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */

public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
            return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String getPurchaseScreenOption()
    {
        System.out.println("Your current balance is: $" + Money.getCustomerMoney());
        System.out.println();

        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M"))
        {
            return "feed money";
        }
        else if (option.equals("S"))
        {
            return "select item";
        }
        else if (option.equals("F"))
        {
            return "finish transaction";
        }
        else
        {
            return "";
        }

    }

    public static String getFeedMoneyScreenOption()
    {
        System.out.println("Your current balance is: $" + Money.getCustomerMoney());
        System.out.println();

        System.out.println("Please enter a whole dollar amount (1, 5, 10, etc.): ");

        String resultMessage = "";

      try {
        int userMoneyInputInt = Integer.parseInt(scanner.nextLine());

        BigDecimal userMoneyInputBigDecimal = BigDecimal.valueOf(userMoneyInputInt);
        userMoneyInputBigDecimal = userMoneyInputBigDecimal.setScale(2);

            if (userMoneyInputBigDecimal.compareTo(Money.dollar) >= 0) {
                Money.addCustomerMoney(userMoneyInputBigDecimal);
                //Log customer money addition in Audit file
                Audit.printNewAuditLog("MONEY FED:", "",
                        "", userMoneyInputBigDecimal, Money.getCustomerMoney());
                resultMessage = "Current balance updated.";
            }
            return resultMessage;

        } catch (InputMismatchException | NumberFormatException e) {
            resultMessage = "There was an error with your input.";
            return resultMessage;
        }
    }

    public static String getSelectItemScreenOption()
    {
        Inventory.printInventoryList();
        System.out.println();
        System.out.println("Your current balance is: $" + Money.getCustomerMoney());
        System.out.println();
        System.out.println("Please enter an item selector ID (A1, B4, C9, etc.): ");

        String selectionResult = "";

        try {
            String userSelectInputString = scanner.nextLine().toUpperCase();

            for (Snack snack : Inventory.inventoryList) {
                // Checks if Selector Input matches any Snack object selectors, Checks Snack Inventory,
                // Checks if customer wallet has enough money to buy snack
                if (userSelectInputString.equals(snack.getSelector()) && snack.getInventoryAmount() > 0 &&
                        (Money.getCustomerMoney().compareTo(snack.getPrice()) > 0 ||
                                Money.getCustomerMoney().compareTo(snack.getPrice()) == 0)) {

                    BigDecimal customerStartingMoney = Money.getCustomerMoney();
                    snack.setInventoryAmount(snack.getInventoryAmount() - 1);
                    Money.setCustomerMoney(customerStartingMoney.subtract(snack.getPrice()));
                    selectionResult = "Item Dispensed: " + snack.getName() + "\n" +
                                      "Item Price: " + snack.getPrice() + "\n" +
                                      "Money Remaining: " + "$" + Money.getCustomerMoney() + "\n" +
                                      snack.getDispenseMessage();
                    PurchaseCounter.setPurchaseCounter(PurchaseCounter.getPurchaseCounter() + 1);
                    //if transaction valid, Purchase Counter is updated;
                    //if it's the customer's first purchase, all items discounted by $1
                    //if it's the customer's second purchase, all items returned to original price
                    if (PurchaseCounter.getPurchaseCounter() == PurchaseCounter.onePurchase) {
                        for (Snack snackItem : Inventory.inventoryList) {
                            snackItem.setPrice(snackItem.getPrice().subtract(Money.dollar));
                        }
                    } else if (PurchaseCounter.getPurchaseCounter() == PurchaseCounter.twoPurchases) {
                        for (Snack snackItem : Inventory.inventoryList) {
                            snackItem.setPrice(snackItem.getPrice().add(Money.dollar));
                        }
                    }
                    //log customer purchase in Audit file
                    Audit.printNewAuditLog(snack.getName(), snack.getType(), snack.getSelector(),
                            customerStartingMoney, Money.getCustomerMoney());
                    break;
                } else {
                    selectionResult = "Unable to complete transaction.";
                }
            }
        } catch (InputMismatchException e) {
//            UserOutput.displayMessage("There was an error with your input.");
            selectionResult = "There was an error with your input.";
        }
        return selectionResult;
    }

}

