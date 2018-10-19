package com.globant.techtest.rodcruzh.ctrl;

import com.globant.techtest.rodcruzh.entity.Person;
import com.globant.techtest.rodcruzh.svc.PersonSvc;
import com.globant.techtest.rodcruzh.util.enumeration.SourcePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost" })
public class PersonCtrl {

    @Autowired
    private PersonSvc personSvc;

    @RequestMapping(value = "/csv")
    public void findCelebrityCSV() {
        Optional<Person> celeb = personSvc.findCelebrity(SourcePerson.CSV);
    }

    @RequestMapping(value = "/db")
    public void findCelebrityDB() {
        Optional<Person> celeb = personSvc.findCelebrity(SourcePerson.DB);
    }

}
