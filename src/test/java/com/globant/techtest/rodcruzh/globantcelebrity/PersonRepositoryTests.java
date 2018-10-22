package com.globant.techtest.rodcruzh.globantcelebrity;

import com.globant.techtest.rodcruzh.entity.Person;
import com.globant.techtest.rodcruzh.entity.PersonKnows;
import com.globant.techtest.rodcruzh.repo.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTests {

	@Autowired
	private TestEntityManager em;

	@Autowired
	private PersonRepository personRepo;

	@Test
	public void test01() {
		Person person1 = new Person(1L);
		Person person2 = new Person(2L);
		Person person3 = new Person(3L);
		Person person4 = new Person(4L);
		Person person5 = new Person(5L);

		em.persist(person1);
		em.flush();
		em.persist(person2);
		em.flush();
		em.persist(person3);
		em.flush();
		em.persist(person4);
		em.flush();
		em.persist(person5);
		em.flush();

		PersonKnows knows12 = new PersonKnows(person1, person2);
		PersonKnows knows15 = new PersonKnows(person1, person5);
		PersonKnows knows25 = new PersonKnows(person2, person5);
		PersonKnows knows34 = new PersonKnows(person3, person4);
		PersonKnows knows35 = new PersonKnows(person3, person5);
		PersonKnows knows45 = new PersonKnows(person4, person5);

		em.persist(knows12);
		em.flush();
		em.persist(knows15);
		em.flush();
		em.persist(knows25);
		em.flush();
		em.persist(knows34);
		em.flush();
		em.persist(knows35);
		em.flush();
		em.persist(knows45);
		em.flush();

		List<Person> people = new ArrayList<>();

		personRepo.findAll().forEach(people::add);
		Assertions.assertThat(people.size() == 5);
	}

}
