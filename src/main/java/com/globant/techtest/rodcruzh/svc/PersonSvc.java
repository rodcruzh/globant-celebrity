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
        long n = people.size();

        // If person is known by (n - 1) and person knows nobody, (s)he's a celeb!
        strPeople.filter(p -> p.getKnownBy() != null && p.getKnownBy().size() == n - 1 && p.getKnownPeople() == null)
                .limit(1).forEach(celebrity::add);

        return !celebrity.isEmpty() ? Optional.of(celebrity.get(0)) : Optional.empty();
    }

    public List<Person> loadPersonDataFromCSV() {
        List<String[]> contents = new ArrayList<>();
        Map<Long, Person> peopleMap = new HashMap<>();
        CSVLoader loader = new CSVLoader();

        try {
            contents = loader.loadDataFromCSV("data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] item : contents) {
            Long idPerson = Long.parseLong(item[0]), idKnows = Long.parseLong(item[1]);

            if (peopleMap.get(idPerson) == null)
                peopleMap.put(idPerson, new Person(idPerson));
            if (peopleMap.get(idKnows) == null)
                peopleMap.put(idKnows, new Person(idKnows));

            if (peopleMap.get(idPerson).getKnownPeople() == null)
                peopleMap.get(idPerson).setKnownPeople(new ArrayList<>());

            peopleMap.get(idPerson).getKnownPeople().add(new PersonKnows(new Person(idPerson), new Person(idKnows)));

            if (peopleMap.get(idKnows).getKnownBy() == null)
                peopleMap.get(idKnows).setKnownBy(new ArrayList<>());

            peopleMap.get(idKnows).getKnownBy().add(new PersonKnows(new Person(idKnows), new Person(idPerson)));
        }

        List<Person> people = new ArrayList<>();

        for (Map.Entry<Long, Person> entry : peopleMap.entrySet())
            people.add(entry.getValue());

        return people;
    }

}
