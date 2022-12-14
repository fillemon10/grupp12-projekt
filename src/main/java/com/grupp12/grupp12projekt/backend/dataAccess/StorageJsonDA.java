package com.grupp12.grupp12projekt.backend.dataAccess;
import com.grupp12.grupp12projekt.backend.Storage;
import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class of storages data access
 */

public class StorageJsonDA implements IDataAccess<Storage> {

    private JsonDBTemplate connection = ConnectionJson.getConnection();
    private List<Storage> storages = new ArrayList<>();
    @Override
    public Storage getById(long id) {
        String jxQuery = String.format("/.[id='%s']", id);
        return connection.find(jxQuery, Storage.class).get(0);
    }

    @Override
    public List<Storage> getAll() {
        storages = connection.findAll(Storage.class);
        return storages;
    }

    @Override
    public void add(Storage storage) {
        storage.setId(getLastId()+1);
        connection.insert(storage);
    }

    @Override
    public void update(Storage storage) {
        connection.upsert(storage);
    }

    @Override
    public void delete(Storage storage) {
        connection.remove(storage, Storage.class);
    }

    public int getLastId(){
        Storage storage;
        storages = getAll();
        storage = storages.get(storages.size() - 1);
        return storage.getId();
    }
}



