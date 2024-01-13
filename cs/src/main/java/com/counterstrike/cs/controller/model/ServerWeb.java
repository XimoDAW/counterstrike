package com.counterstrike.cs.controller.model;

import com.counterstrike.cs.domain.entity.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServerWeb {
    private int id;
    private String name;
    private String country;
    private Team team;
    private com.counterstrike.cs.domain.entity.Server server;
}
