package com.counterstrike.cs.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Weapon {
    private int id;
    private String name;
    private String type;
    private int power;
    private int bullet;
    private int price;
}
