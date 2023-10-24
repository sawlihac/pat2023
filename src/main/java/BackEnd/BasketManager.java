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
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csawl
 */
public class BasketManager {

    public static void add(String nm, int qty) throws IOException {

        double cost = ItemManager.getItemCost(nm);

        FileWriter writer = new FileWriter("data//basket.txt", true);

        PrintWriter pw = new PrintWriter(writer);
        pw.println(nm + "#" + cost + "#" + qty);
        pw.close();

    }

    public static String getCart() {
        String output = "";
        try {
            String line = "";

            File F = new File("Data\\Basket.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                if (line.length() > 0) {
                    Scanner linesc = new Scanner(line).useDelimiter("#").useLocale(Locale.UK);

                    String name = linesc.next();
                    double cost = linesc.nextDouble();
                    int qty = linesc.nextInt();
                    output += name + " " + qty + " " + qty * cost + "\n";

                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return output;

    }

    public static String getcosT() {
        String output = "";
        try {
            String line = "";

            File F = new File("Data\\Basket.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                if (line.length() > 0) {
                    Scanner linesc = new Scanner(line).useDelimiter("#").useLocale(Locale.UK);

                    String name = linesc.next();
                    double cost = linesc.nextDouble();
                    int qty = linesc.nextInt();
                    output += qty*cost ;

                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return output;
    }
}
