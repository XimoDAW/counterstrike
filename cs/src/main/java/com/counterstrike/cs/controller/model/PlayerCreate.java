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
    private int level;
    private Integer birthYear;
    private Integer deathYear;
    private int idTeam;
    private int idServer;
    private List<Integer> idWeapons;

}
