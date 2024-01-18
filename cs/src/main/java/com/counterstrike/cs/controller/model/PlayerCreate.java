package com.counterstrike.cs.controller.model;

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
    private int id_team;
    private int id_server;
    private List<Integer> id_weapons;
}
