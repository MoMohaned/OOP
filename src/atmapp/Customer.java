/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author x18742295
 */
public class Customer extends AtmApp {

    private static void add(int i, String dylan, String farrell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class myCustomer implements Serializable {

        private int cardNo;
        
        private String fname;
        private String lname;
        private Date dob;

        public myCustomer() {
        }

        public myCustomer(int cardNo, String fname, String lname) {
            this.cardNo = cardNo;
            this.fname = fname;
            this.lname = lname;
        }

        public myCustomer(int cardNo, String fname, String lname, Date dob) {
            this.cardNo = cardNo;
            this.fname = fname;
            this.lname = lname;
            this.dob = dob;
        }

        public int getCardNo() {
            return cardNo;
        }

        public String getFname() {
            return fname;
        }

        public String getLname() {
            return lname;
        }

        public void setCardNo(int cardNo) {
            this.cardNo = cardNo;
        }

        public void setFname(String Fname) {
            this.fname = fname;
        }

        public void setLname(String Lname) {
            this.lname = lname;
        }

        public Date getDob() {
            return dob;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        @Override
        public String toString() {
            return "Customer{" + "fname=" + fname + ", lname=" + lname + ", cardNo=" + cardNo + '}';
        }

    }
    /**
 *
 * @author Lim Hong Chun
 */
    
    
    public void saveCust(java.awt.event.ActionEvent evt){
        ArrayList<Customer> myCust = new ArrayList<>();
        Customer c = new Customer();
        myCust.add(c);
        Customer.add(58632924, "Alfie", "Steve");
        Customer.add(72104974, "David", "Smith");
        Customer.add(57292501, "Jonny", "Brown");
        try {
            File f = new File("Customer");
            FileOutputStream fos = new FileOutputStream(f, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myCust);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Problem writing file " + e);
        }
    }
    
    
    public void readCust(java.awt.event.ActionEvent evt) throws IOException, ClassNotFoundException {
        try {
            File f = new File("Customer");
            FileInputStream fos = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            ArrayList<Customer.myCustomer> custTemp;
            String s = "";
            custTemp = (ArrayList<Customer.myCustomer>) ois.readObject();
            for (Customer.myCustomer t : custTemp) {
                s = s + t.getCardNo() +t.getFname()+ t.getLname()+t.getDob()+"\n";
            }
            fos.close();
            ois.close();
        } catch (IOException e) {
            System.out.println("Problem reading file " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtmGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
