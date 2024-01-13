package com.counterstrike.cs.persistance.entity;

import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.domain.entity.Weapon;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = "player")
@Data
@NoArgsConstructor
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String country;
    private int level;
    private Integer birthYear;
    private Integer deathYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team")
    private TeamEntity team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_server")
    private ServerEntity server;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Weapon> weapon;
}
