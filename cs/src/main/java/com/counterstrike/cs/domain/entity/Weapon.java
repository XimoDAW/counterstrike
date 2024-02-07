package com.counterstrike.cs.domain.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Weapon {
    private int id;
    private String name;
    private Type type;
    @Min(value = 0, message = "EL PODER DEL ARMA NO PUEDE SER NEGATIVO")
    private int power;
    @Min(value = 0, message = "LAS BALAS NO PUEDEN SER NEGATIVAS")
    private int bullet;
    @Min(value = 0, message = "EL PRECIO NO PUEDE SER NEGATIVO")
    private int price;

    public Weapon(int id, String name, Type type, int power, int bullet, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.power = power;
        this.bullet = bullet;
        this.price = price;
    }
}
