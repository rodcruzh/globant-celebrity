package com.globant.techtest.rodcruzh.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<PersonKnows> knownPeople;

    @OneToMany(mappedBy = "known", fetch = FetchType.EAGER)
    private List<PersonKnows> knownBy;

    public Person() { }

    public Person(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonKnows> getKnownPeople() {
        return knownPeople;
    }

    public void setKnownPeople(List<PersonKnows> knownPeople) {
        this.knownPeople = knownPeople;
    }

    public List<PersonKnows> getKnownBy() {
        return knownBy;
    }

    public void setKnownBy(List<PersonKnows> knownBy) {
        this.knownBy = knownBy;
    }

}
