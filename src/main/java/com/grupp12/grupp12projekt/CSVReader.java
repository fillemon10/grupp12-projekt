package com.grupp12.grupp12projekt;

import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader {
    private String[][] recipes;
    com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new BufferedReader(new FileReader("recipe.csv"))); {
        List<String[]> lines;
        try {
            lines = reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        recipes = lines.toArray(new String[lines.size()][]);
    }

    public String[][] getRecipes() {
        return recipes;
    }

    public CSVReader() throws FileNotFoundException {
    }
}
