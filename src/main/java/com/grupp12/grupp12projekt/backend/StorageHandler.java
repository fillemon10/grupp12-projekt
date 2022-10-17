package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;

import java.util.List;

public class StorageHandler {
    private static StorageHandler instance;
    private DataAccessFacade dataAccessFacade = DataAccessFacade.getInstance();


    public static StorageHandler getInstance() {
        if (instance == null)
            instance = new StorageHandler();
        return instance;
    }

    public Storage getStorageFromDatabase(int id){
        Storage storage = dataAccessFacade.getStorageById(id);
        return storage;
    }

    public void addStorageToDatabase(Storage storage){
        dataAccessFacade.addStorageToDatabase(storage);
    }

    public void updateStorageInDatabase(Storage storage){
        dataAccessFacade.updateStorageInDatabase(storage);
    }



}
