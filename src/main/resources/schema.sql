CREATE SCHEMA IF NOT EXISTS library;
SET SCHEMA library;

DROP TABLE IF EXISTS book;

CREATE TABLE book(
    id INT AUTO_INCREMENT,
    title CHAR(255) NOT NULL,
    author CHAR(255) NOT NULL,
    year_of_print INT,
    is_available BOOLEAN,
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
    book_id INT,
    user_id INT,
    date_of_rent DATE,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (user_id) REFERENCES client(id),
    PRIMARY KEY (id)
);

INSERT INTO library.book(title,author,year_of_print,is_available) VALUES('Spring w akcji','Craig Walls',2020,true);