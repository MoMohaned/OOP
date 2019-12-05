/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

import javax.swing.JOptionPane;

/**
 *
 * @author x17500429
 */
public class LogIn {
    protected String accountNo;
    protected String pin;
    protected boolean validAccountNo = false;
    protected boolean validPin = false;
    protected boolean validLogin = false;
    
    public LogIn(String accountNo, String pin) {
        this.accountNo = accountNo;
        this.pin = pin;
    }
    public LogIn() {
        
    }
    
    public boolean isValidLogin() {
        return validLogin;
    }
    
    public void setValidLogin(boolean validLogin) {
        this.validLogin = validLogin;
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

    public boolean isValidAccountNo() {
        return validAccountNo;
    }

    public void setValidAccountNo(boolean validAccountNo) {
        this.validAccountNo = validAccountNo;
    }

    public boolean isValidPin() {
        return validPin;
    }

    public void setValidPin(boolean validPin) {
        this.validPin = validPin;
    }
    
    //here i will check to make sure there not empty answercheck for account number and make sure its is a minimum of 10 char
    //also check for account number and make sure its is a minimum of 10 char and up too 12
    
    public boolean CheckAccountNo() {
        if (accountNo.isEmpty() || accountNo.length() < 10 ) {
            validLogin = false;
            
        }else {
            validLogin = true;
        }
//        for (int i = 0; i < accountNo.length(); i++) {
//        char c = accountNo.charAt (i);
//        if(Character.isDigit(c) != true ) {
//            JOptionPane.showMessageDialog(null, "Error, Must be Numeric");
//        break;
//            } else{
//                    validLogin = true;
//            }
//        }
    return validLogin;
    }
    
    //checking pin 
    //here i will check to make sure there not empty answercheck for account number and make sure its is a minimum of 10 char
    //also check for account number and make sure its is a minimum of 10 char and up too 12
     public boolean CheckPin() {
         System.out.println("pin" + pin.length());
        if ( pin.length() == 4 ) {
            validPin = true;
            System.out.println("checkPin()" + validPin);
        }else{
           validPin = false;
        }
//        for (int i = 0; i < pin.length(); i++) {
//            char c = pin.charAt (i);
//            if(Character.isDigit(c) != true ) {
//                JOptionPane.showMessageDialog(null, "Error, Must be Numeric");
//            break;
//                } else{
//                        validPin = true;
//                }
//        }
        return validPin;
    }
    //check both accoun no and pin are true
    //check if valid login boolean is true
     public void validateLogin(boolean validAccountNo, boolean validPin) {
         if (validAccountNo == validPin && validPin !=false ){
             validLogin = true;
         }
     }
}
