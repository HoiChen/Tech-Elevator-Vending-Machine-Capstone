package com.techelevator.application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Locale;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileOutputStream;

public class Audit {


    //Checks for existing Audit file. Creates a new one if none exists already.
    public static void checkForAuditFile() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a", Locale.ENGLISH);
        LocalDateTime now = LocalDateTime.now();

        File auditFile = new File("Audit.txt");

        if(!auditFile.exists()) {
            try (PrintWriter auditFileWriter = new PrintWriter(auditFile)) {
                auditFileWriter.println(dtf.format(now) + " *** AUDIT FILE CREATED ***");
            }
            catch (IOException e) {
                System.out.println("Encountered error creating a new Audit file.");
            }
        }
    }


    //All-purpose Audit file update method
    //      Notes:
    //      Method will take 5 Strings, combine them with a Date & Time String,
    //      and print them as formatted columns.If not being used to log snack purchase,
    //      the snackTpe and snackSelector parameters should be entered as empty Strings ("").
    public static void printNewAuditLog(String snackNameOrMoneyAction, String snackType, String snackSelector,
                                        BigDecimal moneyFirstAmount, BigDecimal moneySecondAmount) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a", Locale.ENGLISH);
        LocalDateTime now = LocalDateTime.now();

        String timeStamp = dtf.format(now);

        int col1Width = 25;
        int col2Width = 17;
        int col3Width = 14;
        int col4Width = 7;
        int col5Width = 7;
        int col6Width = 7;

        File auditFile = new File("Audit.txt");

        try(PrintWriter auditFileWriter = new PrintWriter(new FileOutputStream(auditFile, true))) {

            auditFileWriter.printf("%-" + col1Width + "s %-" + col2Width + "s %-" + col3Width + "s %-" +
                    col4Width + "s %" + col5Width + "s %" + col6Width +
                    "s%n", timeStamp, snackNameOrMoneyAction, snackType, snackSelector, moneyFirstAmount,
                    moneySecondAmount);
        }
        catch (IOException e) {
            System.out.println("Encountered error writing in Audit file.");
        }
    }


}
