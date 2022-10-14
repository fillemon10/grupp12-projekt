package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserJsonDA implements IDataAccess<User> {

    private JsonDBTemplate connection = ConnectionJson.getConnection();
    private List<User> users = new ArrayList<>();

    @Override
    public User getById(long id) {
        String jxQuery = String.format("/.[id='%s']", id);
        return connection.find(jxQuery, User.class).get(0);
    }

    @Override
    public List<User> getAll() {
        return connection.findAll(User.class);
    }

    @Override
    public void add(User user) {
        connection.insert(user);
    }

    @Override
    public void update(User user, String[] params) {
        user.setUsername(params[0]);
        user.setPassword(params[1]);
        connection.upsert(user);
    }

    @Override
    public void delete(User user) {
        connection.remove(user, User.class);
    }

    public int getLastId(){
        User user;
        users = getAll();
        user = users.get(users.size() - 1);
        return user.getId();
    }

}

