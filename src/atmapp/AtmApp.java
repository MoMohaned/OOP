/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

/**
 *
 * @author power
 */
public class AtmApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String accountNo;
        Double balance;
        boolean showLogIn = true;
        
        loginGui log = new loginGui();
        log.setVisible(showLogIn);
        
        AtmGui atm = new AtmGui();
        atm.setVisible(false);
        
        
        
        
        
    }
    
}
