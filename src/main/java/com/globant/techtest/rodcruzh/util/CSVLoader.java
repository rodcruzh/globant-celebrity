package com.globant.techtest.rodcruzh.util;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    public List<String[]> loadDataFromCSV(String fileName) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        CSVReader reader = new CSVReader(new FileReader(file), ',');
        List<String[]> contents = new ArrayList<>();
        String[] row = null;

        while ((row = reader.readNext()) != null)
           contents.add(row);

        reader.close();

        return contents;
    }

}
