package com.globant.techtest.rodcruzh.repo;

import com.globant.techtest.rodcruzh.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

}
