package com.ivanov_sergey.game.entity;

import lombok.*;

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

    @Column(name = "count_of_ended_games")
    private int countOfEndedGames;

    @Column(name = "count_of_killed_personages")
    private int countOfKilledPersonages;

    @Column(name = "max_health")
    private int maxHealth;

    @Column(name = "current_health")
    private int currentHealth;

    @Column(name = "strength")
    private int strength;

    @Column(name = "dexterity")
    private int dexterity;

    @Column(name = "current_location")
    private String currentLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Hero(String name) {
        this.name = name;
    }

    public void initValuesOfFields(){
        this.maxHealth = 300;
        this.currentHealth = 300;
        this.strength = 20;
        this.dexterity = 50;
    }
}
