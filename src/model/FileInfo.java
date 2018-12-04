package model;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
/**
this Class is for the Bonusaufgabe 8
 @author Team 15
 @Version 28.11.2018
 */

public class FileInfo {
    //reader for DataLogHammer.txt as string
    private static String myCustomers;

    static {
        try {
            myCustomers = new String(Files.readAllBytes(Paths.get("log/DataLogHammers.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //reader for DataLogMaterial.txt as string
    private static String myOrders;

    static {
        try {
            myOrders = new String(Files.readAllBytes(Paths.get("log/DataLogMaterial.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int price ; // price of the object
    private int customer ; // Customer ID
    private String name ; // Customer name (nicht benutzt)
    private int bought ; // money spent by Customer on order



    /** (Constructor, creates the editor for the log
     *
     * @param name of the Customer (nicht benutzt)
     *
     */

    public FileInfo(String name){
        this.name = name ;
        int randomZahl = (int)( Math.random() * 5) + 35;
        int randomC = (int )(Math.random() * 500000 + 3000);
        this.bought = randomZahl ;
        this.price = randomZahl * 25 ;
        this.customer = randomC;

    }

    public static void updateSold(){
        FileInfo myOrder = new FileInfo("Hammer");



        PrintWriter writer = null;
        try {
            /*new XML file for BonusAufgabe*/
            writer = new PrintWriter("log/DataLogHammers.txt", StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myCustomers = myCustomers + "\n"+  new Date() + " Customer " + myOrder.customer + " paid " + myOrder.price + "$ for " + myOrder.bought + " Hammers." ;
        writer.print(myCustomers);
        writer.close();
    }


    public static void updateBoughtMaterial(){
        FileInfo myOrder = new FileInfo("Material");
        int randomWorth = (int )(Math.random() * 500000 + 300);


        PrintWriter writer = null;
        try {
            writer = new PrintWriter("log/DataLogMaterial.txt", StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myOrders = myOrders + "\n"+  new Date() + " spent  on Material : " + StartStation.spent  ;
        writer.print(myOrders);
        writer.close();
    }
}
