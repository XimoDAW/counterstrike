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
    private Team team;
    private Server server;
}