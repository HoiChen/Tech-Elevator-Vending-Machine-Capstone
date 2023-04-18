package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void feedingMoneyTest_100Dollars() {
        Money testMoney = new Money();
        BigDecimal expected = BigDecimal.valueOf(100.00);
        
    }

    @Test
    public void setCustomerMoney() {
    }

    @Test
    public void addCustomerMoney() {
    }

    @Test
    public void returnChange() {
    }
}