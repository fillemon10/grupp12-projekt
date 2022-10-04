package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;
import io.jsondb.query.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface UserDataAccess  {
    public User getUser(long id);
    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateUser(User user, String[] params);

    public void deleteUser(User user);

}

