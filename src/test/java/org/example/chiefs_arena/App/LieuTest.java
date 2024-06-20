package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LieuTest {

    /**
     * Teste le constructeur et les getters de la classe Lieu.
     */
    @Test
    void testLieuConstructorAndGetters() {
        Lieu lieu = new Lieu("Salle A", 100);
        assertEquals("Salle A", lieu.getNom());
        assertEquals(100, lieu.getCapacite());
    }


    /**
     * Teste la méthode setNom de la classe Lieu.
     */
    @Test
    void testSetNom() {
        Lieu lieu = new Lieu("Salle A", 100);
        lieu.setNom("Salle B");
        assertEquals("Salle B", lieu.getNom());
    }

    /**
     * Teste la méthode setCapacite de la classe Lieu.
     */
    @Test
    void testSetCapacite() {
        Lieu lieu = new Lieu("Salle A", 100);
        lieu.setCapacite(200);
        assertEquals(200, lieu.getCapacite());
    }
}
