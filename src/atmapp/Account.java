/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author x17500429
 */
public class Account {
    
    protected String accountNo;
    protected String pin;
    protected Double balance;
    
    public Account(String accountNo, String pin,Double balance) {
        this.accountNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }
    
    public Account() {
        
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public void generateBalance() {
        
        LogIn atm = new LogIn();
        System.out.print(accountNo);
        System.out.print(pin);
        
        balance = ThreadLocalRandom.current().nextDouble(100.0, 500.0);
        balance = Math.round(balance * 100.0) / 100.0;
        System.out.println(balance);
    }

}
