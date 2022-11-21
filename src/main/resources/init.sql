CREATE DATABASE my_db;

USE my_db;

CREATE TABLE users
(
    username varchar(15),
    password varchar(100),
    enabled  tinyint(1),
    PRIMARY KEY (username)
);

INSERT INTO my_db.users (username, password, enabled)
VALUES ('zaur', '{noop}zaur', 1),
       ('elena', '{noop}elena', 1),
       ('ivan', '{noop}ivan', 1);

-- ________________________

CREATE TABLE employees
(
    id         int NOT NULL AUTO_INCREMENT,
    name       varchar(15),
    surname    varchar(25),
    department varchar(20),
    salary     int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.employees (name, surname, department, salary)
VALUES ('Oleg', 'Ivanov', 'Sales', 700),
       ('Sergey', 'Ivanov', 'IT', 500),
       ('Nikolay', 'Vozov', 'IT', 600),
       ('Anton', 'Sizov', 'IT', 400),
       ('Nina', 'Sidorova', 'HR', 850);

-- ________________________

CREATE TABLE authorities
(
    username  varchar(15),
    authority varchar(25),
    FOREIGN KEY (username) references users (username)
);

INSERT INTO my_db.authorities (username, authority)
VALUES ('zaur', 'ROLE_EMPLOYEE'),
       ('elena', 'ROLE_HR'),
       ('ivan', 'ROLE_HR'),
       ('ivan', 'ROLE_MANAGER');

-- ________________________

CREATE TABLE my_db.weapons
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.weapons (name, location_id)
VALUES ('gun', 1),
       ('tor', 1);

-- ________________________

CREATE TABLE my_db.potions
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.potions (name, location_id)
VALUES ('grass', 1),
       ('koktail', 1),
       ('water', 2),
       ('box', 2);

-- ________________________

CREATE TABLE my_db.keys
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.keys (name, location_id)
VALUES ('first', 1),
       ('second', 1);

-- ________________________

CREATE TABLE my_db.armors
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.armors (name, location_id)
VALUES ('sreel', 1),
       ('silver', 1);

-- ________________________

CREATE TABLE my_db.locations
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    repository_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.locations (name, repository_id)
VALUES ('Living room', 1),
       ('Kitchen room', 1);

-- ________________________

CREATE TABLE my_db.heroes
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    count_of_games int,
    health int,
    strength int,
    dexterity int,
    current_location varchar(100),
    PRIMARY KEY (id)
);

-- ________________________

CREATE TABLE my_db.personages
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    health int,
    strength int,
    dexterity int,
    location_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.personages (name, health, strength, dexterity, location_id)
VALUES ('Aragon', 100, 50, 70, 1),
       ('Gendalf', 150, 70, 80, 1);

-- ________________________

CREATE TABLE my_db.visitors
(
    id            int NOT NULL AUTO_INCREMENT,
    name          varchar(100),
    count_of_games int,
    PRIMARY KEY (id)
);

-- ________________________

CREATE TABLE my_db.questions
(
    id   int NOT NULL AUTO_INCREMENT,
    text varchar(100),
    PRIMARY KEY (id)
);

-- INSERT INTO my_db.questions (text)
-- VALUES ('Ты потерял память. Прнять вызов?'),
--        ('Ты принял вызов. Поднимешься на мостик к капитану?'),
--        ('Ты отклонил вызов. Поражение'),
--        ('Ты поднялся на мостик. Ты кто?'),
--        ('Ты не пошел на переговоры. Поражение?'),
--        ('Тебя вернули домой. Победа'),
--        ('Твою ложь разоблачили. Поражение');


INSERT INTO my_db.questions (text)
VALUES ('You are loose memory. Take the challenge?'),
       ('You accepted the challenge. Will you go up to the bridge to the captain?'),
       ('You declined the call. Defeat'),
       ('You went up to the bridge. Who are you?'),
       ('You did not negotiate. Defeat?'),
       ('You have been brought home. Victory'),
       ('Your lies have been exposed. Defeat');

-- ________________________

CREATE TABLE my_db.answers
(
    id               int NOT NULL AUTO_INCREMENT,
    text             varchar(100),
    next_question varchar(100),
    PRIMARY KEY (id)
);

-- INSERT INTO my_db.answers (text,  next_question)
-- VALUES ('Отклонить вызов', 'Ты отклонил вызов. Поражение'),
--        ('Принять вызов', 'Ты принял вызов. Поднимешься на мостик к капитану?'),
--        ('Подняться на мостик', 'Ты поднялся на мостик. Ты кто?'),
--        ('Отказаться подниматься на мостик', 'Ты не пошел на переговоры. Поражение?'),
--        ('Рассказать правду о себе', 'Тебя вернули домой. Победа'),
--        ('Солгать о себе', 'Твою ложь разоблачили. Поражение');

INSERT INTO my_db.answers (text,  next_question)
VALUES ('Reject a call', 'You declined the call. Defeat'),
       ('Take the challenge', 'You accepted the challenge. Will you go up to the bridge to the captain?'),
       ('Climb to the bridge', 'You went up to the bridge. Who are you?'),
       ('Refuse to go up to the bridge', 'You did not negotiate. Defeat'),
       ('Tell the truth about yourself', 'You have been brought home. Victory'),
       ('Lie about yourself', 'Your lies have been exposed. Defeat');

-- ________________________

CREATE TABLE my_db.join_table (
                                  question_id int NOT NULL,
                                  answer_id int NOT NULL,
                                  PRIMARY KEY (question_id, answer_id),
                                  FOREIGN KEY (question_id) references my_db.questions(id),
                                  FOREIGN KEY (answer_id) references my_db.answers(id)
) ;

INSERT INTO my_db.join_table (question_id, answer_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6);

-- ________________________

CREATE TABLE my_db.repositoryes
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(25),
    PRIMARY KEY (id)
);

INSERT INTO my_db.repositoryes (name)
VALUES ('initial');

-- ________________________



create user 'bestuser'@'%' identified by 'bestuser';
grant all privileges on *.* to 'bestuser'@'%' with grant option;
flush privileges;