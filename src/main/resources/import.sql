INSERT INTO person(id_person, name) VALUES (1, 'alice');
INSERT INTO person(id_person, name) VALUES (2, 'bob');
INSERT INTO person(id_person, name) VALUES (3, 'kate');
INSERT INTO person(id_person, name) VALUES (4, 'john');
INSERT INTO person(id_person, name) VALUES (5, 'david');

INSERT INTO person_knows(id_person, id_known) VALUES(1, 2);
INSERT INTO person_knows(id_person, id_known) VALUES(1, 5);
INSERT INTO person_knows(id_person, id_known) VALUES(2, 5);
INSERT INTO person_knows(id_person, id_known) VALUES(3, 4);
INSERT INTO person_knows(id_person, id_known) VALUES(3, 5);
INSERT INTO person_knows(id_person, id_known) VALUES(4, 5);