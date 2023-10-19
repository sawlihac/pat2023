/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csawl
 */
public class ItemManager {

    public static int getNumItems() {
        int count = 0;
        try {
            String line = "";

            File F = new File("Data\\items.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();

                count++;
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public static String[] getItemNames() {
        String[] itemNames = new String[getNumItems()];
        int currentLine = 0;
        try {
            String line = "";

            File F = new File("Data\\items.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                Scanner linesc = new Scanner(line).useDelimiter("#");

                String name = linesc.next();
                String description = linesc.next();
                String pictureLocation = linesc.next();
                int cost = linesc.nextInt();
                itemNames[currentLine] = name;
                currentLine++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemNames;

    }

    public static String getItemDescription(String nameToCheck) {
        String descriptionOutput = "";

        try {
            String line = "";

            File F = new File("Data\\items.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                Scanner linesc = new Scanner(line).useDelimiter("#");

                String name = linesc.next();
                String description = linesc.next();
                String pictureLocation = linesc.next();
                int cost = linesc.nextInt();
                if (name.equalsIgnoreCase(nameToCheck)) {
                    descriptionOutput = description;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descriptionOutput;
    }

    public static double getItemCost(String nameToCheck) {
        double outputcost = 0;

        try {
            String line = "";

            File F = new File("Data\\items.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                Scanner linesc = new Scanner(line).useDelimiter("#");

                String name = linesc.next();
                String description = linesc.next();
                String pictureLocation = linesc.next();
                 int cost=linesc.nextInt();
                if (name.equalsIgnoreCase(nameToCheck)) {
                    outputcost = cost;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outputcost;
    }
    
    public static String getItemPicture(String nameToCheck) {
        String pictureOutput = "";

        try {
            String line = "";

            File F = new File("Data\\items.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                Scanner linesc = new Scanner(line).useDelimiter("#");

                String name = linesc.next();
                String description = linesc.next();
                String pictureLocation = linesc.next();
                 int cost=linesc.nextInt();
                if (name.equalsIgnoreCase(nameToCheck)) {
                    pictureOutput = pictureLocation;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pictureOutput;
    }

}
