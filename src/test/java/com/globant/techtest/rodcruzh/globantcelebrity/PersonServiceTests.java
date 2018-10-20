package com.globant.techtest.rodcruzh.globantcelebrity;

import com.globant.techtest.rodcruzh.entity.Person;
import com.globant.techtest.rodcruzh.repo.PersonRepository;
import com.globant.techtest.rodcruzh.svc.PersonSvc;
import com.globant.techtest.rodcruzh.util.enumeration.SourcePerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class PersonServiceTests {

    @TestConfiguration
    static class PersonServiceTestConfig {

        @Bean
        public PersonSvc personService() {
            return new PersonSvc();
        }

    }

    @Autowired
    private PersonSvc personSvc;

    @MockBean
    private PersonRepository personRepo;

    @Test
    public void test01() {
        Optional<Person> optPerson = personSvc.findCelebrity(SourcePerson.CSV);
        assertThat(optPerson.get().getId()).isEqualTo(5L);
    }

}
