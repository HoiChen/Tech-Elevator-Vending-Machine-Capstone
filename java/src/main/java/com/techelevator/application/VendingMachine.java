package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import static com.techelevator.application.Money.getCustomerMoney;
import static com.techelevator.application.Money.zero;

public class VendingMachine 
{
    public void run()
    {
        //Before user gets home screen, program reads through catering file,
        // and stocks inventory list
        Inventory.stockNewInventory();

        //Create new Audit file if one doesn't already exist
        Audit.checkForAuditFile();

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // Display the vending machine slots; will call getInventoryList()
                UserOutput.displayVendingItemsScreen();
                Inventory.printInventoryList();
            }
            else if(choice.equals("purchase"))
            {
                // Display Purchase screen and further options
                while(true)
                {
                    UserOutput.displayPurchaseScreen();
                    String purchaseChoice = UserInput.getPurchaseScreenOption();
                    if(purchaseChoice.equals("feed money")) {
                        //Display Feed Money screen
                        while(true) {
                            UserOutput.displayFeedMoneyScreen();
                            String transactionOutcome = UserInput.getFeedMoneyScreenOption();
                            UserOutput.displayMessage(transactionOutcome);
                            break;
                        }
                    } else if (purchaseChoice.equals("select item")){
                        // Display Select Item screen
                        while(true) {
                            UserOutput.displaySelectItemScreen();
                            String selectionOutcome = UserInput.getSelectItemScreenOption();
                            UserOutput.displayMessage(selectionOutcome);
                            break;
                        }
                    } else if (purchaseChoice.equals("finish transaction")){
                        // Return to Home screen and return any remaining change
                        Audit.printNewAuditLog("CHANGE GIVEN:", "",
                                "", Money.getCustomerMoney(), zero);
                        UserOutput.displayMessage(Money.returnChange());
                        PurchaseCounter.setPurchaseCounter(PurchaseCounter.resetToZero);
                        break;
                    }
                }
            }
            else if(choice.equals("exit"))
            {
                //Display Goodbye screen and end program
                UserOutput.displayGoodbyeScreen();
                break;
            }
        }
    }

}
