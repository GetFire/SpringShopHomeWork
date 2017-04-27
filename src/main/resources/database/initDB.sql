CREATE DATABASE security;


CREATE TABLE IF NOT EXISTS products (
  id           INT         NOT NULL AUTO_INCREMENT,
  name         VARCHAR(30) NOT NULL,
  manufacturer VARCHAR(30) NOT NULL,
  price        INT         NOT NULL,
  description  VARCHAR(50)          DEFAULT NULL,
  photo        MEDIUMBLOB,
  PRIMARY KEY (id),
  UNIQUE KEY products_id_uindex (id)
);


CREATE TABLE IF NOT EXISTS users
(
  id       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  login    VARCHAR(30)     NOT NULL,
  password VARCHAR(30)     NOT NULL,
  role     VARCHAR(20)     NOT NULL
);
CREATE UNIQUE INDEX users_id_uindex
  ON security.users (id);


CREATE TABLE IF NOT EXISTS roles (
  id   INT(11)     NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY roles_id_uindex (id)
);


CREATE TABLE IF NOT EXISTS user_roles
(
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT role_id FOREIGN KEY (role_id) REFERENCES roles (id)
);