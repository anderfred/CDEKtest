DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;
CREATE TABLE entity(
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)DEFAULT CHARSET=utf8;