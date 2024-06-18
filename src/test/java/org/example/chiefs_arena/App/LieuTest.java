package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LieuTest {
    @Test
    void testLieuConstructorAndGetters() {
        Lieu lieu = new Lieu("Salle A", 100);
        assertEquals("Salle A", lieu.getNom());
        assertEquals(100, lieu.getCapacite());
    }

    @Test
    void testSetNom() {
        Lieu lieu = new Lieu("Salle A", 100);
        lieu.setNom("Salle B");
        assertEquals("Salle B", lieu.getNom());
    }

    @Test
    void testSetCapacite() {
        Lieu lieu = new Lieu("Salle A", 100);
        lieu.setCapacite(200);
        assertEquals(200, lieu.getCapacite());
    }
}
