package com.grupp12.grupp12projekt.backend;

import java.util.List;

public interface IDataAccess<T> {

        void createCollection(Class<T> classType);

        T get(long id);

        List<T> getAll();

        void save(T t);

        void update(T t, String[] params);

        void delete(T t);
}

