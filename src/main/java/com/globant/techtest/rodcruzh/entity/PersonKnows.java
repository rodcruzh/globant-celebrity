package com.globant.techtest.rodcruzh.entity;

import javax.persistence.*;

@Entity
@Table(name = "person_knows")
public class PersonKnows {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person_knows")
    private Long id;

    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne
    private Person person;

    @JoinColumn(name = "id_known", referencedColumnName = "id_person")
    @ManyToOne
    private Person known;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getKnown() {
        return known;
    }

    public void setKnown(Person known) {
        this.known = known;
    }

}
