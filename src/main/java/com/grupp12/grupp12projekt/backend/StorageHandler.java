package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;

import java.util.List;

/**
 * This class handles users storages from the database
 */

public class StorageHandler {
    private static StorageHandler instance;
    private static DataAccessFacade dataAccessFacade;

    private StorageHandler() {
        dataAccessFacade = DataAccessFacade.getInstance();
    }

    static StorageHandler getInstance() {
        if (instance == null)
            instance = new StorageHandler();
        return instance;
    }

    Storage getStorageFromDatabase(int id) {
        List<Storage> storages = dataAccessFacade.getAllStorages();
        for (Storage storage : storages) {
            if (storage.getId() == id)
                return storage;
        }
        throw new IllegalArgumentException("Storage does not exist.");
    }

    void addNewStorageToDatabase(Storage storage) {
        dataAccessFacade.addStorageToDatabase(storage);
    }

    void updateStorageInDatabase(Storage storage) {
        dataAccessFacade.updateStorageInDatabase(storage);
    }


}
