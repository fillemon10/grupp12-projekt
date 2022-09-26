package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.Recipe;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader {
    private List<Recipe> recipes;

    public CSVReader() throws FileNotFoundException {
        com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new BufferedReader(new FileReader("recipe.csv"))); {
            List<String[]> lines;
            try {
                lines = reader.readAll();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvException e) {
                throw new RuntimeException(e);
            }
            for (String[] line : lines) {

            }


        }
    }
    public String getRecipes() {
        return null;
    }

    public static class Model {
    }
}
