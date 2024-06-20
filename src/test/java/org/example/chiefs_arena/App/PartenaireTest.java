package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartenaireTest {

    Partenaire partenaire = new Partenaire("00017821", "HelloFresh", 30000, "Cuisinez les recettes de HelloFresh");

    /**
     * Teste la méthode getId de la classe Partenaire.
     */
    @Test
    void setId() {
        assertEquals("00017821", partenaire.getId());
    }

    /**
     * Teste la méthode getNom de la classe Partenaire.
     */
    @Test
    void setNom() {
        assertEquals("HelloFresh", partenaire.getNom());
    }

    /**
     * Teste la méthode getContribution de la classe Partenaire.
     */
    @Test
    void setContribution() {
        assertEquals(30000, partenaire.getContribution());
    }

    /**
     * Teste la méthode getContraintes de la classe Partenaire.
     */
    @Test
    void setContraintes() {
        assertEquals("Cuisinez les recettes de HelloFresh", partenaire.getContraintes());
    }
}