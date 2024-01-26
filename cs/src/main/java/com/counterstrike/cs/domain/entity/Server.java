package com.counterstrike.cs.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Server {
    private int id;
    private String name;
    private String country;

    public Server(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}