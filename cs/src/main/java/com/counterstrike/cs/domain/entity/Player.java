package com.counterstrike.cs.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private String country;
    private int level;
    private Integer birthYear;
    private Integer deathYear;
    private Team team;
    private Server server;
    private List<Weapon> weapons;

    public Player(int id, String name, String country, int level, Integer birthYear, Integer deathYear, Team team, Server server, List<Weapon> weapons) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.level = level;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.team = team;
        this.server = server;
        this.weapons = weapons;
    }
}
