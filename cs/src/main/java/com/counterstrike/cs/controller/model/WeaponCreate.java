package com.counterstrike.cs.controller.model;

import com.counterstrike.cs.persistance.entity.TypeEntity;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeaponCreate {
    private String name;
    private int idType;
    private int power;
    private int bullet;
    private int price;
}
