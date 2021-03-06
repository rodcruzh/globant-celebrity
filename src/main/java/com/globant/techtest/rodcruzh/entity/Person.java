package com.globant.techtest.rodcruzh.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private List<PersonKnows> knownPeople;

    @OneToMany(mappedBy = "known", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
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

    @Override
    public boolean equals(Object object) {
        if (object instanceof Person)
            if (this.id.equals(((Person) object).getId()))
                return true;
            else return false;
        else return false;
    }

}
