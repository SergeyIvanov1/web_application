CREATE DATABASE my_db;

USE my_db;

CREATE TABLE users (
                       username varchar(15),
                       password varchar(100),
                       enabled tinyint(1),
                       PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
                             username varchar(15),
                             authority varchar(25),
                             FOREIGN KEY (username) references users(username)
) ;

CREATE TABLE employees (
                           id int NOT NULL AUTO_INCREMENT,
                           name varchar(15),
                           surname varchar(25),
                           department varchar(20),
                           salary int,
                           PRIMARY KEY (id)
) ;

INSERT INTO my_db.employees (name, surname, department, salary)
VALUES
    ('Oleg', 'Ivanov', 'Sales', 700),
    ('Sergey', 'Ivanov', 'IT', 500),
    ('Nikolay', 'Vozov', 'IT', 600),
    ('Anton', 'Sizov', 'IT', 400),
    ('Nina', 'Sidorova', 'HR', 850);

INSERT INTO my_db.users (username, password, enabled)
VALUES
    ('zaur', '{noop}zaur', 1),
    ('elena', '{noop}elena', 1),
    ('ivan', '{noop}ivan', 1);

INSERT INTO my_db.authorities (username, authority)
VALUES
    ('zaur', 'ROLE_EMPLOYEE'),
    ('elena', 'ROLE_HR'),
    ('ivan', 'ROLE_HR'),
    ('ivan', 'ROLE_MANAGER');

create user 'bestuser'@'%' identified by 'bestuser';
grant all privileges on *.* to 'bestuser'@'%' with grant option;
flush privileges;