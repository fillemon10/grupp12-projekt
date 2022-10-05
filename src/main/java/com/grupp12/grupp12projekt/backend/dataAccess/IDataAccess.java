package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.User;

import java.util.List;

public interface IDataAccess<T> {
    public T getByID(long id);
    public List<T> getAll();

    public void add(T t);

    public void update(T t, String[] params);

    public void delete(T t);

}
