package com.globant.techtest.rodcruzh.svc;

import com.globant.techtest.rodcruzh.entity.Person;
import com.globant.techtest.rodcruzh.entity.PersonKnows;
import com.globant.techtest.rodcruzh.util.CSVLoader;
import com.globant.techtest.rodcruzh.util.enumeration.SourcePerson;
import com.globant.techtest.rodcruzh.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class PersonSvc {

    @Autowired
    private PersonRepository personRepo;

    public Optional<Person> findCelebrity(SourcePerson source) {
        List<Person> people = new ArrayList<>(), celebrity = new ArrayList<>();

        // Load data
        switch (source) {
            case CSV:
                people = loadPersonDataFromCSV();
                break;
            case DB:
                personRepo.findAll().forEach(people::add);
                break;
            default:
                break;
        }

        Stream<Person> strPeople = people.stream();

        // Count people (n)
        long n = strPeople.count();

        // If person is known by (n - 1) and person knows 0, (s)he's a celeb!
        strPeople.filter(p -> p.getKnownBy().size() == n - 1 && p.getKnownPeople().size() == 0).limit(1).forEach(celebrity::add);

        return !celebrity.isEmpty() ? Optional.of(celebrity.get(0)) : Optional.empty();
    }

    public List<Person> loadPersonDataFromCSV() {
        List<String[]> contents = new ArrayList<>();
        Map<String, List<PersonKnows>> schema = new HashMap<>();
        List<Person> people = new ArrayList<>();
        CSVLoader loader = new CSVLoader();

        try {
            contents = loader.loadDataFromCSV("data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] item : contents) {
            if (schema.get(item[0]) == null) {
                List<PersonKnows> personKnows = new ArrayList<>();
                personKnows.add(new PersonKnows(new Person(Long.parseLong(item[0])), new Person(Long.parseLong(item[1]))));
                schema.put(item[0], personKnows);
            } else
                schema.get(item[0]).add(new PersonKnows(new Person(Long.parseLong(item[0])), new Person(Long.parseLong(item[1]))));
        }

        for (Map.Entry<String, List<PersonKnows>> entry : schema.entrySet()) {
            Person person = new Person();
            person.setId(Long.parseLong(entry.getKey()));
            person.setKnownPeople(entry.getValue());
            people.add(person);
        }

        return people;
    }

}
