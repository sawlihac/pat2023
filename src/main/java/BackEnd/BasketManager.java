/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;


import static BackEnd.ItemManager.getNumItems;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author csawl
 */
public class BasketManager {
    public static void add(String nm,double price) throws IOException {
        FileWriter writer = new FileWriter("data//basket.txt", true);
                 
        PrintWriter pw= new PrintWriter(writer);
        pw.println("#" + nm + "#"+ price);
        pw.close();
 
    }  public static String[] getItemName() {
        String[] itemNames = new String[getNumItems()];
        int currentLine = 0;
        try {
            String line = "";

            File F = new File("Data\\Basket.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                Scanner linesc = new Scanner(line).useDelimiter("#");

                String name = linesc.next();
                String description = linesc.next();
                String pictureLocation = linesc.next();
                double cost = linesc.nextDouble();
                itemNames[currentLine] = name;
                currentLine++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemNames;
        
}
     
}
