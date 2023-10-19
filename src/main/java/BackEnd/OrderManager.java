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
public class OrderManager {

    public static void add(String nm, int qty) throws IOException {

        double cost = ItemManager.getItemCost(nm);

        FileWriter writer = new FileWriter("data//Order.txt", true);

        PrintWriter pw = new PrintWriter(writer);
        pw.println(nm + "#" + cost + "#" + qty);
        pw.close();

    }

    public static String[] getItem() {
        String[] itemNames = new String[getNumItems()];
        int currentLine = 0;
        try {
            String line = "";

            File F = new File("Data\\Order.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                if (line.length() > 0) {
                    Scanner linesc = new Scanner(line).useDelimiter("#");

                    String name = linesc.next();
                    int cost = linesc.nextInt();
                    int qty = linesc.nextInt();
                    itemNames[currentLine] = name;
                    currentLine++;

                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < currentLine; i++) {
            System.out.println(itemNames[i]);

        }

        return itemNames;

    }

}
