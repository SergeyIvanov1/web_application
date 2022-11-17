CREATE DATABASE my_db;

USE my_db;

CREATE TABLE users
(
    username varchar(15),
    password varchar(100),
    enabled  tinyint(1),
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  varchar(15),
    authority varchar(25),
    FOREIGN KEY (username) references users (username)
);

CREATE TABLE employees
(
    id         int NOT NULL AUTO_INCREMENT,
    name       varchar(15),
    surname    varchar(25),
    department varchar(20),
    salary     int,
    PRIMARY KEY (id)
);

CREATE TABLE my_db.questions
(
    id   int NOT NULL AUTO_INCREMENT,
    text varchar(100),
    PRIMARY KEY (id)
);

CREATE TABLE my_db.answers
(
    id            int NOT NULL AUTO_INCREMENT,
    text          varchar(100),
    next_question varchar(100),
    PRIMARY KEY (id)
);

CREATE TABLE my_db.join_table
(
    question_id int NOT NULL,
    answer_id   int NOT NULL,
    PRIMARY KEY (question_id, answer_id),
    FOREIGN KEY (question_id) references my_db.questions (id),
    FOREIGN KEY (answer_id) references my_db.answers (id)
);

INSERT INTO my_db.employees (name, surname, department, salary)
VALUES ('Oleg', 'Ivanov', 'Sales', 700),
       ('Sergey', 'Ivanov', 'IT', 500),
       ('Nikolay', 'Vozov', 'IT', 600),
       ('Anton', 'Sizov', 'IT', 400),
       ('Nina', 'Sidorova', 'HR', 850);

INSERT INTO my_db.users (username, password, enabled)
VALUES ('zaur', '{noop}zaur', 1),
       ('elena', '{noop}elena', 1),
       ('ivan', '{noop}ivan', 1);

INSERT INTO my_db.authorities (username, authority)
VALUES ('zaur', 'ROLE_EMPLOYEE'),
       ('elena', 'ROLE_HR'),
       ('ivan', 'ROLE_HR'),
       ('ivan', 'ROLE_MANAGER');
#
INSERT INTO my_db.questions (text)
VALUES ('Ты потерял память. Прнять вызов?'),
       ('Ты принял вызов. Поднимешься на мостик к капитану?'),
       ('Ты отклонил вызов. Поражение'),
       ('Ты поднялся на мостик. Ты кто?'),
       ('Ты не пошел на переговоры. Поражение?'),
       ('Тебя вернули домой. Победа'),
       ('Твою ложь разоблачили. Поражение');

INSERT INTO my_db.answers (text,  next_question)
VALUES ('Отклонить вызов', 'Ты отклонил вызов. Поражение'),
       ('Принять вызов', 'Ты принял вызов. Поднимешься на мостик к капитану?'),
       ('Подняться на мостик', 'Ты поднялся на мостик. Ты кто?'),
       ('Отказаться подниматься на мостик', 'Ты не пошел на переговоры. Поражение?'),
       ('Рассказать правду о себе', 'Тебя вернули домой. Победа'),
       ('Солгать о себе', 'Твою ложь разоблачили. Поражение');
#
# INSERT INTO my_db.join_table (question_id, answer_id)
# VALUES
#     ('zaur', '{noop}zaur', 1),
#     ('elena', '{noop}elena', 1),
#     ('ivan', '{noop}ivan', 1);

create user 'bestuser'@'%' identified by 'bestuser';
grant all privileges on *.* to 'bestuser'@'%' with grant option;
flush privileges;