package com.techelevator;

import com.techelevator.application.Money;
import com.techelevator.ui.UserInput;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MoneyTests {

    @Test
    public void test_Return_Change_From_Three_Dollars_Fifty_Cents() {

        Money test = new Money();

        test.setCustomerMoney(new BigDecimal("3.50"));

        String expected = "Your change is: " + 3 + " dollar(s), " +
                2 + " quarter(s), " + 0 +
                " dime(s), and " + 0 + " nickel(s).";

        String result = test.returnChange();

        assertEquals(expected, result);

    }

    
}
