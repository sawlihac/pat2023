
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.sun.source.tree.ImportTree;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csawl
 */
public class UserManager {

    public static boolean validateLogin(String usernameTF, String passwordTF) {
        try {
            String line = "";
            
            File F = new File("Data\\Practice.txt");
            Scanner filesc = new Scanner(F);
            while (filesc.hasNextLine()) {
                line = filesc.nextLine();
                Scanner linesc = new Scanner(line).useDelimiter("#");

                String currentUsername = linesc.next();
                String currentPassword = linesc.next();

                if (currentUsername.equals(usernameTF)&&currentPassword.equals(passwordTF)) {
                    return true;
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public static boolean save(String username, String password) throws IOException {
        FileWriter writer = new FileWriter("data//Practice.txt", true);
        writer.write("#" + username + "#" + password);
        writer.close();
        return true;
    }

}
