package com.counterstrike.cs.domain.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PlayerTest {
    @Nested
    @DisplayName("Test de constructor Player")
    class getConstructorTest {
        Team teamA = new Team(1, "TeamA", "TERRORIST");
        Server serverA = new Server(1, "serverA", "Spain");

        private List<Weapon> weapons = List.of(
                new Weapon(1, "Weapon1", "PISTOL", 1, 1, 1),
                new Weapon(2, "Weapon2", "HEAVY WEAPON", 2, 2, 2)
        );

        private Player playerA = new Player(1, "PlayerA", "Spain", 30, 1999, 0, teamA, serverA, weapons);
        @DisplayName("Comprobar el constructor")
        @Test
        public void constructorTest() {
            assertAll(
                    () -> assertTrue(((Object) playerA.getId()).getClass().getSimpleName().equals("Integer")),
                    () -> assertTrue(((Object) playerA.getName()).getClass().getSimpleName().equals("String")),
                    () -> assertTrue(((Object) playerA.getCountry()).getClass().getSimpleName().equals("String")),
                    () -> assertTrue(((Object) playerA.getLevel()).getClass().getSimpleName().equals("Integer")),
                    () -> assertTrue(((Object) playerA.getBirthYear()).getClass().getSimpleName().equals("Integer")),
                    () -> assertTrue(((Object) playerA.getDeathYear()).getClass().getSimpleName().equals("Integer")),
                    () -> assertTrue(((Object) playerA.getTeam()).getClass().getSimpleName().equals("Team")),
                    () -> assertTrue(((Object) playerA.getServer()).getClass().getSimpleName().equals("Server"))
            );
        }
    }
}
