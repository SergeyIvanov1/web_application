USE my_db;
drop table my_db.weapons;
drop table my_db.potions;

drop table my_db.armors;
drop table my_db.personages;

drop table my_db.heroes;
drop table my_db.locations;
drop table my_db.inventories;
drop table my_db.helpers;
drop table my_db.repositoryes;
drop table my_db.quests;

CREATE TABLE my_db.weapons
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    inventory_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.weapons (name, location_id)
VALUES ('stick', 1),
       ('stun-gun', 2),
       ('wrench', 6);

-- ________________________

CREATE TABLE my_db.potions
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    inventory_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.potions (name, location_id)
VALUES ('coffee', 1),
       ('koktail', 2),
       ('water', 4);

-- ________________________

CREATE TABLE my_db.armors
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    inventory_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.armors (name, location_id)
VALUES ('shield', 2),
       ('magic-hauberk', 4);

-- ________________________

CREATE TABLE my_db.locations
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    repository_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.locations (name, repository_id)
VALUES ('Gates', 1),
       ('Forest', 1),
       ('Town', 1),
       ('Mountain', 1),
       ('Field', 1),
       ('Swamp', 1),
       ('Village', 1);

-- ________________________

CREATE TABLE my_db.inventories
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    PRIMARY KEY (id)
);

INSERT INTO my_db.inventories (name)
VALUES ('Hero repository');

-- ________________________

CREATE TABLE my_db.heroes
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    count_of_ended_games int,
    count_of_killed_personages int,
    max_health int,
    current_health int,
    strength int,
    dexterity int,
    current_location varchar(100),
    inventory_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (inventory_id) REFERENCES my_db.inventories(id)
);

INSERT INTO my_db.heroes (name, count_of_ended_games, count_of_killed_personages, max_health, current_health, strength, dexterity, inventory_id)
VALUES ('Hero', 0, 0, 300, 300, 20, 50, 1),
       ('Po', 0, 0, 300, 300, 20, 50, 1),
       ('Nick', 0, 0, 300, 300, 20, 50, 1);

-- ________________________

CREATE TABLE my_db.personages
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    max_health int,
    current_health int,
    strength int,
    dexterity int,
    location_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.personages (name, max_health, current_health, strength, dexterity, location_id)
VALUES ('Guarder', 100, 100, 50, 70, 1),
       ('Forester', 50, 50, 40, 40, 2),
       ('Escaped-prisoner', 40, 40, 20, 50, 3),
       ('Gnome', 80, 80, 10, 20, 4),
       ('Tramp', 80, 80, 30, 30, 5),
       ('Hermit', 80, 80, 30, 30, 6),
       ('Cheater', 15, 15, 50, 80, 7);

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

CREATE TABLE my_db.helpers
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    inventory_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.helpers (name, location_id, inventory_id)
VALUES ('present', 3, 0),
       ('key', 5, 0),
       ('cookie', 6, 0);

-- ________________________

CREATE TABLE my_db.quests
(
    id   int NOT NULL AUTO_INCREMENT,
    text varchar(100),
    is_finished tinyint(1),
    personage_id int,
    PRIMARY KEY (id)
);

drop table my_db.issues;
drop table my_db.replies;

CREATE TABLE my_db.issues
(
    id   int NOT NULL AUTO_INCREMENT,
    text varchar(850),
    personage_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.issues (text, personage_id)
VALUES ('Hello. What do you want?', 1),
       ('This place is dangerous. You can to be killed here.', 1),
       ('I do not know, where you can to find so human, but i know, Tramp help you. You can to find him on the Field.', 1),
       ('Hi. Can I help you?.', 2),
       ('You will help me, I will can help you. Escape prisoner was here and steal my present for my wife. Find him and take my present. He is in the Town.', 2),
       ('Get out!!! While I not killed you.', 3),
       ('You must pass by. I do not want speak with you!', 4),
       ('Hello. What do you need?', 5),
       ('I so long no eating sweets, what I ready to anything. Give me sweets and I give you hint, where you will can to find key for decrypting.', 5),
       ('Who are you? Why do you walk on the Swamp?', 6),
       ('Oh no, I have no key, but if i would have, I do not give you its.', 6),
       ('I heard, that in our places walk something travelers. Who are you? ', 7),
       ('I can find any things, of course, for small pay?', 7);

-- ________________________

CREATE TABLE my_db.replies
(
    id               int NOT NULL AUTO_INCREMENT,
    text             varchar(850),
    issue_id int,
    next_issue varchar(800),
    PRIMARY KEY (id)
);

INSERT INTO my_db.replies (text,  issue_id, next_issue)
VALUES ('Hi. I have a very important letter. I know what I can to find here a human which help me to decrypt my letter.', 1, 'This place is dangerous. You can to be killed here.'),
       ('Nothing. I need to go.', 1, null),
       ('I do not need your advice.', 2, 'fight'),
       ('Do not worry. I am strong. I can care about myself.', 2, 'I do not know, where you can to find so human, but i know, Tramp help you. You can to find him on the Field.'),
       ('Thanks for your info. I am going to find Tramp.', 3, null),
       ('I want to fight with you.', 4, 'fight'),
       ('I search Tramp.', 4, 'You will help me, I will can help you. Escape prisoner was here and steal my present for my wife. Find him and take my present. He is in the Town.'),
       ('Ok. I will find present for you.', 5, null),
       ('You must speak with me and tell me about how I can to find Tramp.', 7, null),
       ('Sorry. I walk away.', 7, null),
       ('I want to fight with you.', 8, 'fight'),
       ('I need the key. I have a very important letter, but it encripted, you must to help me to decrypt my letter.', 8, 'I so long no eating sweets, what I ready to anything. Give me sweets and I give you hint, where you will can to find key for decrypting.'),
       ('Ok. I find sweets for you.', 9, null),
       ('I need the key.', 10, 'Oh no, I have no key, but if i would have, I do not give you its.'),
       ('Nothing. I am going to next location.', 10, null),
       ('You will give me my key or I take it myself.', 11, 'fight'),
       ('Tell me, where I can find it.', 11, null),
       ('None of your business.', 12, 'fight'),
       ('I want to pass for ended game.', 12, null),
       ('Nothing do not need. I need to go.', 13, null);

-- ________________________

USE my_db;
drop table my_db.authorities;
drop table my_db.employees;
drop table my_db.users;

drop table my_db.join_table;
drop table my_db.questions;
drop table my_db.answers;

drop table my_db.visitors;

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