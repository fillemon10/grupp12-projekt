package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;
import java.util.List;

/**
 * This class handles users storages from the database
 */

public class StorageHandler {
    private static StorageHandler instance;
    private DataAccessFacade dataAccessFacade = DataAccessFacade.getInstance();


    public static StorageHandler getInstance() {
        if (instance == null)
            instance = new StorageHandler();
        return instance;
    }

    public Storage getStorageFromDatabase(int id) {
        List<Storage> storages = dataAccessFacade.getAllStorages();
        for (Storage storage : storages) {
            if (storage.getId() == id)
                return storage;
        }
        throw new IllegalArgumentException("Storage does not exist.");
    }

    public void addNewStorageToDatabase(Storage storage) {
        dataAccessFacade.addStorageToDatabase(storage);
    }

    public void updateStorageInDatabase(Storage storage) {
        dataAccessFacade.updateStorageInDatabase(storage);
    }


}
