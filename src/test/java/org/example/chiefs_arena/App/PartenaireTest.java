package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartenaireTest {

    Partenaire partenaire = new Partenaire("00017821", "HelloFresh", 30000, "Cuisinez les recettes de HelloFresh");
    @Test
    void setId() {
        assertEquals("00017821", partenaire.getId());
    }

    @Test
    void setNom() {
        assertEquals("HelloFresh", partenaire.getNom());
    }

    @Test
    void setContribution() {
        assertEquals(30000, partenaire.getContribution());
    }

    @Test
    void setContraintes() {
        assertEquals("Cuisinez les recettes de HelloFresh", partenaire.getContraintes());
    }
}