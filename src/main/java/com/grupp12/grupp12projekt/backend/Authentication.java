package com.grupp12.grupp12projekt.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Authentication {
    public User authenticateUser(String username, String password) {
        User user = new User(0,username,password,0,null);
        return user;
    }

    public User loadUserFromFile(){
        try {
            File myObj = new File("src/main/resources/loginDetails.txt");
            Scanner myReader = new Scanner(myObj);
            String username = myReader.nextLine();
            String password = myReader.nextLine();
            myReader.close();
            return new User(0, username, password, 0, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveUserToFile(String username, String password){
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/loginDetails.txt");
            myWriter.write( username + "\n" + password);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
