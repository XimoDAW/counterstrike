package com.counterstrike.cs.controller.model;

import com.counterstrike.cs.common.validation.ValidLevel;
import com.counterstrike.cs.common.validation.ValidYear;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlayerCreate {
    private String name;
    private String country;

    @ValidLevel
    private int level;
    @ValidYear
    private Integer birthYear;
    @ValidYear
    private Integer deathYear;
    private int id_team;
    private int id_server;
    private List<Integer> id_weapons;
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
