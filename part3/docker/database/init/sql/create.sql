CREATE DATABASE cgm CHARACTER SET utf8 COLLATE utf8_general_ci;

USE cgm;

CREATE TABLE IF NOT EXISTS user
(
  id INT(11) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(50) NOT NULL,
  password VARCHAR(200) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR (50) NOT NULL,
  birthday DATE NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT uk_email UNIQUE (email),
  CONSTRAINT uk_login UNIQUE (user_name)
);


INSERT INTO user (id, user_name, password, email, first_name, last_name, birthday) VALUES (null, "john", "john", "john.doe@cmg.com", "John", "Doe", "1987-01-01");
INSERT INTO user (id, user_name, password, email, first_name, last_name, birthday) VALUES (null, "chuck", "chuck", "chuck.norris@cmg.com", "Chuck", "Norris",  "1987-01-01");
INSERT INTO user (id, user_name, password, email, first_name, last_name, birthday) VALUES (null, "tyron", "tyron", "tyron.lannister@cmg.com", "Tyron", "Lannister", "1900-12-01");
INSERT INTO user (id, user_name, password, email, first_name, last_name, birthday) VALUES (null, "jules", "jules", "jules.cesar@cmg.com", "Jules", "Cesar", "100-12-13");

CREATE TABLE IF NOT EXISTS dentist
(
  id INT(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  image_id INT(11) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 1", "Last Name 1",8);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 2", "Last Name 2",45);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 3", "Last Name 3",5);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 4", "Last Name 4",12);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 5", "Last Name 5",22);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 6", "Last Name 6",30);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 7", "Last Name 7",2);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 8", "Last Name 8",11);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 9", "Last Name 9",15);
INSERT INTO dentist (id, first_name, last_name, image_id) VALUES (null, "Dentist 10", "Last Name 10",3);

