package com.globant.techtest.rodcruzh.util;

import com.globant.techtest.rodcruzh.entity.Person;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    public static List<Person> loadDataFromCSV() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("data.csv"), ',');
        List<Person> people = new ArrayList<>();
        String[] row = null;

        while ((row = reader.readNext()) != null) {
           Person person = new Person();
           person.setId(Long.parseLong(row[0]));
           person.setName(row[1]);
           people.add(person);
        }

        reader.close();

        return people;
    }

}
