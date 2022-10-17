package com.grupp12.grupp12projekt.backend;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "ingredients", schemaVersion = "1.0")
public
class Ingredient{
    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
