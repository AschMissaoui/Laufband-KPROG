package model;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
/**
this Class is for the Bonusaufgabe 5
 @author Team 15
 @Version 28.11.2018
 */

public class FileInfo {
    //reder for myData.txt as string
    public static String myCustomers;

    static {
        try {
            myCustomers = new String(Files.readAllBytes(Paths.get("xml/myData.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int price ;
    private int customer ;
    private String name ;
    /*new XML file for BonusAufgabe*/
    public static File myFile = new File("xml/file.xml");

    public FileInfo(String name){
        this.name = name ;
        int randomP = (int )(Math.random() * 5000 + 1);
        int randomC = (int )(Math.random() * 500000 + 3000);
        this.price = randomP ;
        this.customer = randomC;

    }

    public static void create(){
        FileInfo myOrder = new FileInfo("Hammer");



        PrintWriter writer = null;
        try {
            writer = new PrintWriter("xml/myData.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       myCustomers = myCustomers + "\n"+  new Date() + " Customer " + myOrder.customer + " bought " + myOrder.price + "$ worth of Hammers." ;
        writer.print(myCustomers);
        writer.close();
    }
}
