DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name, email) VALUES ("ユウレト", "yureto@raise-tech.co.jp");
INSERT INTO users (name, email) VALUES ("カナエ", "kanae@raise-tech.co.jp");
INSERT INTO users (name, email) VALUES ("カレン", "karen@raise-tech.co.jp");
INSERT INTO users (name, email) VALUES ("パピ", "papi@raise-tech.co.jp");
