package com.ivanov_sergey.game.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "heroes")
public class Hero implements Serializable {

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

    @Transient
    List<Quest> quests = new ArrayList<>();
    @Transient
    List<Armor> usingArmors = new ArrayList<>();
    @Transient
    List<Weapon> usingWeapons = new ArrayList<>();

    public Hero(String name) {
        this.name = name;
    }

    public void initValuesOfFields() {
        this.maxHealth = 150;
        this.currentHealth = 150;
        this.strength = 20;
        this.dexterity = 20;
    }
}
