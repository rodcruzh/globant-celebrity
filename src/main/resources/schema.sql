CREATE TABLE person (
    id_person INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50)
);

ALTER TABLE person ADD CONSTRAINT pk_person PRIMARY KEY (id_person);

CREATE TABLE person_knows (
    id_person_knows INT NOT NULL AUTO_INCREMENT,
    id_person INT NOT NULL,
    id_known INT NOT NULL
);

ALTER TABLE person_knows ADD CONSTRAINT pk_person_knows PRIMARY KEY (id_person_knows);
ALTER TABLE person_knows ADD FOREIGN KEY (id_person) REFERENCES person (id_person);
ALTER TABLE person_knows ADD FOREIGN KEY (id_known) REFERENCES person (id_person);
