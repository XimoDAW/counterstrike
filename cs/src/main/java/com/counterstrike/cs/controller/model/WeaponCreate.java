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
    private int id_type;
    @Min(value = 0, message = "EL PODER DEL ARMA NO PUEDE SER NEGATIVO")
    private int power;
    @Min(value = 0, message = "LAS BALAS NO PUEDEN SER NEGATIVAS")
    private int bullet;
    @Min(value = 0, message = "EL PRECIO NO PUEDE SER NEGATIVO")
    private int price;
}
