package com.counterstrike.cs.domain.entity;

import com.counterstrike.cs.common.validation.ValidLevel;
import com.counterstrike.cs.common.validation.ValidYear;
import jakarta.persistence.Entity;
import jakarta.validation.ValidationException;
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
    @ValidLevel
    private int level;
    @ValidYear
    private Integer birthYear;
    @ValidYear
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

    public void setBirthYear(Integer birthYear) {
        if(this.deathYear != null && birthYear!= null && this.deathYear < birthYear) {
            throw new ValidationException("El año de nacimiento no puede ser mayor que el año de muerte.");
        }
        this.birthYear = birthYear;
    }
    public void setDeathYear(Integer deathYear) {
        if(this.birthYear != null && deathYear != null &&  this.birthYear > deathYear) {
            throw new ValidationException("El año de nacimiento no puede ser mayor que el año de muerte.");
        }
        this.deathYear = deathYear;
    }
}
