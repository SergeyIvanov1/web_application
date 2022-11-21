package com.ivanov_sergey.game.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "count_of_games")
    private int CountOfGames;

    @Column(name = "health")
    private int health;

    @Column(name = "strength")
    private int strength;

    @Column(name = "dexterity")
    private int dexterity;

    @Column(name = "current_location")
    String currentLocation;

//    private List<> inventory;

    public Hero(String name) {
        this.name = name;
    }

    public void initValuesOfFields(){
        this.health = 200;
        this.strength = 200;
        this.dexterity = 50;
    }
}
