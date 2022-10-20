package com.grupp12.grupp12projekt.backend.dataAccess;

import io.jsondb.JsonDBTemplate;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class that handles the connection to then database instance och the java objects(recipe, ingredients storage and user)
 */

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
