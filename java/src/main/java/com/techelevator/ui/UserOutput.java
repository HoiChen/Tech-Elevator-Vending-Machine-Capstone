package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayPurchaseScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                    Purchase");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayVendingItemsScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 Vending Items");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayFeedMoneyScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 Feed Money");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displaySelectItemScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 Select Item");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayGoodbyeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 Good Bye!");
        System.out.println("***************************************************");
        System.out.println();
    }

}
