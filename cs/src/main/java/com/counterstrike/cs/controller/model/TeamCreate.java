package com.counterstrike.cs.controller.model;

import jakarta.validation.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class TeamCreate {
    private String name;
    private String position;

    public void setPosition(String position) {
        if(!(position.equals("COUNTER TERRORIST") || position.equals("TERRORIST")))
            throw new ValidationException("EL EQUIPO TIENE QUE SER *TERRORIST* O *COUNTER TERRORIST*");
        this.position = position;
    }
}
