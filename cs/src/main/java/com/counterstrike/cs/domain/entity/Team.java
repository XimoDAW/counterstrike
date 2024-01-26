package com.counterstrike.cs.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Team {
    private int id;
    private String name;
    private String position;

    public Team(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}
