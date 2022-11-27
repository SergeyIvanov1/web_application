# Web-application project 

This project implements two parts:
1. Crypto analyzer;
2. Mini game.

Application is using next technologies:
Java 17, Lombok, Tomcat 9, Maven, Log4j, Junit, Mockito, MySQL, Hibernate, 
Docker-compose, HTML, CSS, Servlet, JSTL, Spring MVC, CI.

Path to war file: web_application\target\ROOT.war

Launch application: 

http://myapp-s.com/8080

Also you can use next commands:
- clone repository https://github.com/SergeyIvanov1/web_application.git
- Launch with Docker - (in working directory of terminal) use:
  docker-compose up -d.


## Crypto analyzer

Application encodes and decodes text Caesar's cipher.

In first part of application you can to get crypto analyzer.

On page this application you should specify path to file with text, 
which application must encode/decode.
Result of running application - will be text on page (encode or decode).

#### The program had five modes of using:

##### Encryption. 

For encode text you need specify the key of encoding. 
The program encode the text and return encoded text.

##### Decryption with key. 

The program will request from user the key for decryption. 
If you have encoded text and key of encoding, you can to get decoded text.

##### Manual decryption "Brute Force" method's. 

This part of program is calculating possible keys and decodes text using each key. 
Return results of applying all keys, which depends from amount of language's letters.
User should choose right variant of decoding yourself.

##### Auto Decryption "Brute Force" method's. 

Program will use all possible keys in order automatically. 
Each of decrypted text will verify of program to correct decryption, 
using statistic most frequently words of language. 
Program will choose right decoded text and show it on page.

[//]: # (##### "Manual decryption with statistic". )

[//]: # ()
[//]: # (The program gets the  text and is searching most frequent letters of encrypted text.)

[//]: # ()
[//]: # (By statistics exist  the greatest frequent letters of alphabets, which are using in practice. )

[//]: # (The program is taking first six in order and calculate indexes of letters, )

[//]: # (the key is difference between letter's of indexes. )

[//]: # (Program will choose right decoded text by most frequent words of language and show it on page.)

##### Auto decryption with statistic. 

The program gets the  text and is searching most frequent letters of encrypted text.

By statistics exist  the greatest frequent letters of alphabets, which are using in practice.
The program is taking first six in order and calculate indexes of letters,
the key is difference between letter's of indexes.
Program will choose right decoded text by most frequent words of language and show it on page.

## Mini game.

This is browser game. There is N locations. 
Target of game - to implement quests and quit game from last location.

#### Hero.

Hero has health, strength and dexterity. 
Health determines amount of life. 
Strength shows power of kick during fighting. 
Dexterity determines chance do not get kick in fight.

Hero has inventory there he storage things, which he find.

#### Personage.

Hero can speak with any personage.
Personage can give quest to hero. (To find anything or to bring). Also personage can begin fight with hero if he do not like conversation.

#### Things.

In every location is box, inside can be usefull things: 
armor, potion, helpers, weapons.

Weapon is increasing strength.
Armor is increase dexterity.
Hero can to use potions during figthing  and increase health.
Helpers can to use during executing quests.

#### Fight.

While is fighting hero can to kick apponent to head, body or legs. 
Also he can to close head, body or legs himself.

Opponent also can  kick hero to head, body or legs. and to close head, 
body or legs himself.

If kick was to closed part, health is not decrease.

Also is chance, what hero or opponent can not to get kick (dexterity).

If one part of body is geting kick, decreasing N of health, 
in dependence from strength.

If hero is dead, the game begin from start.

Hero can begin the game from start in any momet of game.

#### Statistics: global and individual.

Global statistic shows:
- count of gamers and their names;
- name hero with maximal of count ended games;
- hero, has max count killed personages.

Individual statistic shows:
- when started current game;
- how many kills of personages is make hero;
- count ended games;
- common of count killed personages during all games this hero.
