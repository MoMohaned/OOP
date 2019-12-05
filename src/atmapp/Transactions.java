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
 * @author Lim Hong Chun
 */
public class Transactions extends AtmApp {

    public static class MyTransactions implements Serializable {

        protected int transactionID;
        protected Date date;
        protected String type;
        protected double amount;
        protected double postBalance;

        public MyTransactions() {
        }

        public MyTransactions(int transactionID, Date date, String type, double amount, double postBalance) {
            this.transactionID = transactionID;
            this.date = date;
            this.type = type;
            this.amount = amount;
            this.postBalance = postBalance;
        }

        

        public int getTransactionID() {
            return transactionID;
        }

        public void setTransactionID(int transactionID) {
            this.transactionID = transactionID;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getPostBalance() {
            return postBalance;
        }

        public void setPostBalance(double postBalance) {
            this.postBalance = postBalance;
        }

    }

    ArrayList<MyTransactions> myTrans = new ArrayList<>();

    public void saveTrans(java.awt.event.ActionEvent evt) throws IOException, ClassNotFoundException {

        try {
            File f = new File("transaction_record");
            FileOutputStream fos = new FileOutputStream(f, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myTrans);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Problem writing file " + e);
        }
    }

    public void readTrans(java.awt.event.ActionEvent evt) throws IOException, ClassNotFoundException {
        try {
            File f = new File("transaction_record");
            FileInputStream fos = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            ArrayList<MyTransactions> transRead;
            String s = "";
            transRead = (ArrayList<MyTransactions>) ois.readObject();
            for (MyTransactions t : transRead) {
                s = s + t.getTransactionID() +t.getDate()+ t.getType() + t.getAmount() + t.getPostBalance() + "\n";
            }
            fos.close();
            ois.close();
        } catch (IOException e) {
            System.out.println("Problem reading file " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtmGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*try{
            while(true){
                Object read = ois.readObject();
                if(read==null)
                    break;
                
                MyTransactions transRead = (MyTransactions) read;
                transRecord.add(transRead);
            }
        }catch(EOFException e){
            
        for(MyTransactions m : transRecord){
            System.out.println(m.transactionID+" "+m.type+" "+m.amount+" "+m.postBalance);
        }
        
        }*/

    }
}
