CREATE TABLE products (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR (30) NOT NULL,
  manufacturer VARCHAR (30) NOT NULL,
  price INT NOT NULL,
  description VARCHAR (50) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY products_id_uindex (id)
);


CREATE TABLE users
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    role VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX users_id_uindex ON shop.users (id);