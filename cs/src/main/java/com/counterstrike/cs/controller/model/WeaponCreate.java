package com.counterstrike.cs.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeaponCreate {
    private String name;
    private String type;
    private int power;
    private int bullet;
    private int price;
}
