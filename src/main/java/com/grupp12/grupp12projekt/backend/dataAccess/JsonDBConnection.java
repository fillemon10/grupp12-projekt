package com.grupp12.grupp12projekt.backend.dataAccess;


import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;

public class JsonDBConnection {
    private static JsonDBTemplate con = null;


    static {
        //Actual location on disk for database files, process should have read-write permissions to this folder
        String dbFilesLocation = "src/main/resources/com/grupp12/grupp12projekt/jsonDatabase";

        //Java package name where POJO's are present
        String baseScanPackage = "com.grupp12.grupp12projekt.backend";

        try{
            ICipher cipher = new Default1Cipher("1r8+24pibarAWgS85/Heeg==");
            con = new JsonDBTemplate(dbFilesLocation, baseScanPackage, cipher);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!con.collectionExists(User .class))
            con.createCollection(User.class);
    }
    public static JsonDBTemplate getConnection() {
        return con;
    }
}
