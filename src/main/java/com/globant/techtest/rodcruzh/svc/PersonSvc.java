package com.globant.techtest.rodcruzh.svc;

import com.globant.techtest.rodcruzh.entity.Person;
import com.globant.techtest.rodcruzh.util.CSVLoader;
import com.globant.techtest.rodcruzh.util.enumeration.SourcePerson;
import com.globant.techtest.rodcruzh.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class PersonSvc {

    @Autowired
    private PersonRepository personRepo;

    public Optional<Person> findCelebrity(SourcePerson source) {
        List<Person> people = new ArrayList<>(), celebrity = new ArrayList<>();

        // Load data
        switch (source) {
            case CSV:
                try {
                    people = CSVLoader.loadDataFromCSV();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

}
