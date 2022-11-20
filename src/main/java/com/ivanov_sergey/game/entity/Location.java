package com.ivanov_sergey.game.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER)
//    @JoinColumn(name = "personage_id")
//    List<Personage> personages;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER)
//    @JoinColumn(name = "location_id")
//    List<Location> nextLocations;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER)
//    @JoinColumn(name = "location_id")
//    List<Location> things;
}
