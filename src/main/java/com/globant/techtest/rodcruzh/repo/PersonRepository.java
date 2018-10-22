package com.globant.techtest.rodcruzh.repo;

import com.globant.techtest.rodcruzh.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
