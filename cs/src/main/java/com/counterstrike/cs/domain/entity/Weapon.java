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

    public Weapon(int id, String name, String type, int power, int bullet, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.power = power;
        this.bullet = bullet;
        this.price = price;
    }
}
