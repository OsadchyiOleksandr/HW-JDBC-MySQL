CREATE USER 'Oleksandr'@'localhost' IDENTIFIED BY 'javaCore';

GRANT ALL PRIVILEGES ON *.* TO 'Oleksandr'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;

CREATE DATABASE company;

USE company;

CREATE TABLE employees (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INTEGER,
    position VARCHAR(255),
    salary FLOAT
);
