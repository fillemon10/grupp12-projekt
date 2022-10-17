package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;

import java.security.GeneralSecurityException;

public class ConnectionJson {
    private static JsonDBTemplate con = null;
    //Actual location on disk for database files, process should have read-write permissions to this folder
    private static String dbFilesLocation = "src/main/resources/com/grupp12/grupp12projekt/jsonDatabase";

    //Java package name where POJO's are present
    private static String baseScanPackage = "com.grupp12.grupp12projekt.backend";

    public static JsonDBTemplate getConnection() {
        if(con == null) {
            try{
                con = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!con.collectionExists(User.class))
            con.createCollection(User.class);
        if (!con.collectionExists(Storage.class))
            con.createCollection(Storage.class);
        if (!con.collectionExists(Ingredient.class))
            con.createCollection(Ingredient.class);
        if (!con.collectionExists(Recipe.class))
            con.createCollection(Recipe.class);
        return con;
    }
}
