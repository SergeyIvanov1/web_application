USE my_db;
drop table if exists my_db.weapons;
drop table if exists my_db.potions;

drop table if exists my_db.armors;
drop table if exists my_db.personages;
drop table if exists my_db.games;

drop table if exists my_db.heroes;
drop table if exists my_db.locations;
drop table if exists my_db.inventories;
drop table if exists my_db.helpers;
drop table if exists my_db.repositoryes;
drop table if exists my_db.quests;
drop table if exists my_db.wickets;

drop table if exists my_db.issues;
drop table if exists my_db.replies;

-- ________________________

CREATE TABLE my_db.weapons
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    value int,
    location_id int,
    inventory_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.weapons (name, value, location_id)
VALUES ('stick', 5, 1),
       ('stun-gun', 10, 2),
       ('wrench', 20,6);

-- ________________________

CREATE TABLE my_db.potions
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    value int,
    location_id int,
    inventory_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.potions (name, value, location_id)
VALUES ('coffee', 20, 1),
       ('koktail', 40, 2),
       ('water', 10, 4);

-- ________________________

CREATE TABLE my_db.armors
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    value int,
    location_id int,
    inventory_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.armors (name, value, location_id)
VALUES ('shield', 20, 2),
       ('magic-hauberk', 40, 4);

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
VALUES ('Hero', 0, 0, 180, 180, 20, 20, 1),
       ('Po', 0, 0, 180, 180, 20, 20, 1),
       ('Nick', 0, 0, 180, 180, 20, 20, 1);

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
VALUES ('Guarder', 60, 60, 40, 25, 1),
       ('Forester', 50, 50, 40, 30, 2),
       ('Prisoner', 40, 40, 20, 30, 3),
       ('Gnome', 80, 80, 10, 25, 4),
       ('Tramp', 70, 70, 30, 30, 5),
       ('Hermit', 80, 80, 30, 30, 6),
       ('Cheater', 55, 55, 30, 40, 7);

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

CREATE TABLE my_db.games
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(100),
    hero_id int,
    repository_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (hero_id) REFERENCES my_db.heroes(id),
    FOREIGN KEY (repository_id) REFERENCES my_db.repositoryes(id)
);

# INSERT INTO my_db.games (name)
# VALUES ('game');

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

INSERT INTO my_db.quests (text, is_finished, personage_id)
VALUES ('Bring present to Forester', 0, 2),
       ('Tramp wants sweets. Find it for him.', 0, 5);

-- ________________________

CREATE TABLE my_db.wickets
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    location_id int,
    is_opened tinyint(1),
    PRIMARY KEY (id)
);

INSERT INTO my_db.wickets (name, location_id, is_opened)
VALUES ('Forest', 1, 1),
       ('Gates', 2, 1),
       ('Town', 2, 1),
       ('Mountain', 2, 0),
       ('Forest', 3, 1),
       ('Forest', 4, 1),
       ('Field', 4, 0),
       ('Mountain', 5, 1),
       ('Swamp', 5, 1),
       ('Village', 5, 0),
       ('Field', 6, 1),
       ('Field', 7, 1);

-- ________________________

CREATE TABLE my_db.issues
(
    id   int NOT NULL AUTO_INCREMENT,
    text varchar(850),
    personage_id int,
    helper_id int,
    PRIMARY KEY (id)
);

INSERT INTO my_db.issues (text, personage_id, helper_id)
VALUES ('Hello. What do you want?', 1, 0),
       ('This place is dangerous. You can to be killed here.', 1, 0),
       ('I do not know, where you can to find so human, but i know, Tramp help you. You can to find him on the Field.', 1, 0),
       ('Hi. Can I help you?.', 2, 0),
       ('You will help me, I will can help you. Escape prisoner was here and steal my present for my wife. Find him and take my present. He is in the Town.', 2, 0),
       ('Get out!!! While I not killed you.', 3, 0),
       ('You must pass by. I do not want speak with you!', 4, 0),
       ('Hello. What do you need?', 5, 0),
       ('I so long no eating sweets, what I ready to anything. Give me sweets and I give you hint, where you will can to find key for decrypting.', 5, 0),
       ('Who are you? Why do you walk on the Swamp?', 6, 0),
       ('Oh no, I have no key, but if I would have, I do not give you its.', 6, 0),
       ('I heard, that in our places walk something travelers. Who are you? ', 7, 0),
       ('I can find any things, of course, for small pay?', 7, 0),
       ('I thank you, what returned my present and I am opening roads in front of you!', 0, 1),
       ('Oh, thank you very much, cookie is good. You helped me. I am allow you going to village. You can find your key there.', 0, 3);

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
       ('You must speak with me and tell me about how I can to find Tramp.', 7, 'fight'),
       ('Sorry. I walk away.', 7, null),
       ('I want to fight with you.', 8, 'fight'),
       ('I need the key. I have a very important letter, but it encripted, you must to help me to decrypt my letter.', 8, 'I so long no eating sweets, what I ready to anything. Give me sweets and I give you hint, where you will can to find key for decrypting.'),
       ('Ok. I find sweets for you.', 9, null),
       ('I need the key.', 10, 'Oh no, I have no key, but if I would have, I do not give you its.'),
       ('Nothing. I am going to next location.', 10, null),
       ('You will give me my key or I take it myself.', 11, 'fight'),
       ('Tell me, where I can find it.', 11, null),
       ('None of your business.', 12, 'fight'),
       ('I want to pass for ended game.', 12, null),
       ('Nothing do not need. I need to go.', 13, null),
       ('Thank you.', 14, null),
       ('I helped you, you helped me', 15, null);

-- ________________________

