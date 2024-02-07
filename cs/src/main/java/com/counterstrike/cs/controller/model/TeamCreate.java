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
}
