package com.counterstrike.cs.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServerTest {
    @Nested
    @DisplayName("Test constructor Server")
    class getConstructorTest {
        Server serverA = new Server(1, "serverA", "Spain");
        Server serverB = new Server(2, "serverB", "France");

        @DisplayName("Comprobar el constructor")
        @Test
        public void constructorTest() {
            assertAll(
                    () -> assertTrue(((Object) serverA.getId()).getClass().getSimpleName().equals("Integer")),
                    () -> assertTrue(((Object) serverA.getName()).getClass().getSimpleName().equals("String")),
                    () -> assertTrue(((Object) serverA.getCountry()).getClass().getSimpleName().equals("String"))
            );
        }
    }
}
