package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConnectionJson {
    private static JsonDBTemplate con = null;

    private static Path currentWorkingDir = Paths.get("").toAbsolutePath();

    //Actual location on disk for database files, process should have read-write permissions to this folder
    private static String dbFilesLocation =  currentWorkingDir +"/src/main/resources/com/grupp12/grupp12projekt/jsonDatabase";

    //Java package name where POJO's are present
    private static String baseScanPackage = "com.grupp12.grupp12projekt.backend";

    static JsonDBTemplate getConnection() {
        if(con == null) {
            try{
                con = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
