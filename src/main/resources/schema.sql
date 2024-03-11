CREATE SCHEMA IF NOT EXISTS library;
SET SCHEMA library;

DROP TABLE IF EXISTS book;

CREATE TABLE book(
    id INT AUTO_INCREMENT,
    title CHAR(255) NOT NULL,
    author CHAR(255) NOT NULL,
    yearOfPrint INT,
    isAvailable BOOLEAN,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS client;

CREATE TABLE client(
    id INT AUTO_INCREMENT,
    name CHAR(255) NOT NULL,
    surname CHAR(255) NOT NULL,
    email CHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS rent;

CREATE TABLE rent(
    id INT AUTO_INCREMENT,
    bookId INT,
    userId INT,
    dateOfRent DATE,
    FOREIGN KEY (bookId) REFERENCES book(id),
    FOREIGN KEY (userId) REFERENCES client(id),
    PRIMARY KEY (id)
);