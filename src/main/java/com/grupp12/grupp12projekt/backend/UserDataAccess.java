package com.grupp12.grupp12projekt.backend;

import io.jsondb.JsonDBTemplate;
import io.jsondb.query.Update;

import java.util.List;

public class UserDataAccess implements IDataAccess<User> {

    static JsonDBTemplate con = DatabaseConnection.getConnection();

    @Override
    public User get(long id) {
        return con.findById(id, User.class);
    }

    @Override
    public List<User> getAll() {
        return con.findAll(User.class);
    }

    @Override
    public void save(User t) {
        con.insert(t);
    }

    @Override
    public void update(User t, String[] params) {
        Update update = new Update();
        update.set("username", params[0]);
        update.set("password", params[1]);
        update.set("storageID", Integer.parseInt(params[2]));
        update.set("favorites", params[3]);
        con.upsert(t, update.toString());
    }

    @Override
    public void delete(User t) {
        con.remove(t, User.class);
    }

    @Override
    public void createCollection(Class<User> classType) {
        con.createCollection(classType);
    }
}

