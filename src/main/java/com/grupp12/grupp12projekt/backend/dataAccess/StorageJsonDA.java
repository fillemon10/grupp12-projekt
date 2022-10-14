package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

public class StorageJsonDA implements IDataAccess<Storage> {
    private JsonDBTemplate connection = ConnectionJson.getConnection();
    private List<Storage> storages = new ArrayList<>();
    @Override
    public Storage getById(long id) {
        return null;
    }

    @Override
    public List<Storage> getAll() {
        return null;
    }

    @Override
    public void add(Storage storage) {

    }

    @Override
    public void update(Storage storage, String[] params) {

    }

    @Override
    public void delete(Storage storage) {
    }

    public Storage getByStorageCode(int storageCode) {
        String jxQuery = String.format("/.[storageCode='%s']", storageCode);
        return connection.find(jxQuery, Storage.class).get(0);
    }
}

