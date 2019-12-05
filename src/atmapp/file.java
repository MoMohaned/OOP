/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author power
 */
public class file extends AtmApp{
    /*
    public static void readTrans(){
        try{
                   File f = new File("cusRecords.txt");
            FileReader fr = new FileReader(f);
            BufferedReader bReader = new BufferedReader(fr);
            String line;
            line = bReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bReader.readLine();
            }
            bReader.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("Probem reading File"); 
        }
    }
    */
    public static void readTrans() {
        try {
            FileInputStream fis = new FileInputStream("ATM_Transactions");
            ArrayList<Transactions> trans = new ArrayList<Transactions>();
            boolean cont = true;

            ObjectInputStream input = new ObjectInputStream(fis);
            while (cont) {
                Object obj = input.readObject();
                if (obj != null) {
                    /*objectsList.add(obj);*/
                    
                } else {
                    cont = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeTrans(ArrayList<Transactions> trans){
        try {
            FileOutputStream fos = new FileOutputStream("ATM_Transactions", true);
            try{
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for(Transactions o : trans){
                    try{
                        oos.writeObject(o);
                    }catch(NotSerializableException e){
                        System.out.println("Object is not serializable");
                        e.printStackTrace();
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Probem writing to File");
        }
    }
    
}
