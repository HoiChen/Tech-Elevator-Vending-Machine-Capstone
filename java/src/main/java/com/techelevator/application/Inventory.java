package com.techelevator.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    //array list to hold snack objects once they're created
    public static List<Snack> inventoryList = new ArrayList<>();

    //method for reading catering list, stocking vending machine, and updating inventory
    public static void stockNewInventory() {

        //Alternate csv catering files to choose from
        //File cateringFile = new File("catering.csv");
        File cateringFile = new File("catering1.csv");

        try (Scanner cateringReader = new Scanner(cateringFile)) {
            while (cateringReader.hasNextLine()) {
                String individualLine = cateringReader.nextLine();
                String[] splitLine = individualLine.split(",");
                if (splitLine.length == 4) {
                    String itemSelector = splitLine[0];
                    String itemName = splitLine[1];
                    BigDecimal itemPrice = new BigDecimal(splitLine[2]);
                    String itemType = splitLine[3];

                    if (itemType.equals("Candy")) {
                        Candy newCandy = new Candy(itemSelector, itemName, itemPrice);
                        inventoryList.add(newCandy);
                    } else if (itemType.equals("Drink")) {
                        Drink newDrink = new Drink(itemSelector, itemName, itemPrice);
                        inventoryList.add(newDrink);
                    } else if (itemType.equals("Gum")) {
                        Gum newGum = new Gum(itemSelector, itemName, itemPrice);
                        inventoryList.add(newGum);
                    } else if (itemType.equals("Munchy")) {
                        Munchies newMunchies = new Munchies(itemSelector, itemName, itemPrice);
                        inventoryList.add(newMunchies);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("There was a problem finding the catering file.");
        }
    }

    //print method for inventory list
    public static void printInventoryList() {
        String result = "";
        for (Snack snack : inventoryList) {
            System.out.println(snack);
        }
    }
}
