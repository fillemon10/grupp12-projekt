package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

public class JsonDBUserDataAccess implements UserDataAccess {

    private JsonDBTemplate connection = new JsonDBConnection().getConnection();
    private List<User> users = new ArrayList<>();

    @Override
    public User getUserByID(long id) {
        String jxQuery = String.format("/.[id='%s']", id);
        return connection.find(jxQuery, User.class).get(0);
    }

    @Override
    public List<User> getAllUsers() {
        return connection.findAll(User.class);
    }

    @Override
    public void addUser(User user) {
        connection.insert(user);
    }

    @Override
    public void updateUser(User user, String[] params) {
        user.setUsername(params[0]);
        user.setPassword(params[1]);
        connection.upsert(user);
    }

    @Override
    public void deleteUser(User user) {
        connection.remove(user, User.class);
    }
}

