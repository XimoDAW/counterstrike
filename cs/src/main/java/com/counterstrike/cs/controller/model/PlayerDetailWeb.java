package com.counterstrike.cs.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDetailWeb {
    private int id;
    private String name;
    private String country;
    private int level;
    private Integer birthYear;
    private Integer deathYear;
    private String team;
    private String server;
    private List<String> weapons;

}
