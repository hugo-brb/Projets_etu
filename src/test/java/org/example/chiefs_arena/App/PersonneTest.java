package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests unitaires pour la classe Personne.
 */
public class PersonneTest {

    /**
     * Teste le constructeur de la classe Personne et les méthodes getters.
     */
    @Test
    void testPersonneConstructorAndGetters() {
        Personne personne = new Personne(1, "Doe", "John", 25, "participant");
        assertEquals(1, personne.getId());
        assertEquals("Doe", personne.getNom());
        assertEquals("John", personne.getPrenom());
        assertEquals(25, personne.getAge());
        assertEquals("participant", personne.getRole());
    }

    /**
     * Teste la méthode setId de la classe Personne.
     */
    @Test
    void testSetId() {
        Personne personne = new Personne(1, "Durand", "John", 25, "participant");
        personne.setId(2);
        assertEquals(2, personne.getId());
    }

    /**
     * Teste la méthode setNom de la classe Personne.
     */
    @Test
    void testSetNom() {
        Personne personne = new Personne(1, "Durand", "John", 25, "participant");
        personne.setNom("Smith");
        assertEquals("Smith", personne.getNom());
    }

    /**
     * Teste la méthode setPrenom de la classe Personne.
     */
    @Test
    void testSetPrenom() {
        Personne personne = new Personne(1, "Durand", "John", 25, "participant");
        personne.setPrenom("Jane");
        assertEquals("Jane", personne.getPrenom());
    }

    /**
     * Teste la méthode setAge de la classe Personne.
     */
    @Test
    void testSetAge() {
        Personne personne = new Personne(1, "Durand", "John", 25, "participant");
        personne.setAge(30);
        assertEquals(30, personne.getAge());
    }

    /**
     * Teste la méthode setRole de la classe Personne.
     */
    @Test
    void testSetRole() {
        Personne personne = new Personne(1, "Durand", "John", 25, "participant");
        personne.setRole("jury");
        assertEquals("jury", personne.getRole());
    }
}
