package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConcoursTest {
    Concours concours = new Concours("CookTempest", new Date(2024, Calendar.AUGUST, 8, 14, 0 , 0), new Date(2024, Calendar.AUGUST, 8, 18, 0 , 0), new Lieu("Castilla", 70));
    @Test
    void setNom() {
        assertEquals("CookTempest", concours.getNom());
    }
    @Test
    void setDescription() {
        assertEquals(null, concours.getDescription());
    }

    @Test
    void setDateDebut() {
        assertEquals(new Date(2024, Calendar.AUGUST, 8, 14, 0 , 0),concours.getDateDebut());
    }

    @Test
    void setDateFin() {
        assertEquals(new Date(2024, Calendar.AUGUST, 8, 18, 0 , 0), concours.getDateFin());
    }

    @Test
    void setLieu() {
        assertEquals(new Lieu("Castilla", 70), concours.getLieu());
    }

    @Test
    void ajouterCategorie() {
    }

    @Test
    void ajouterPartenaire() {
    }

    @Test
    void ajouterPersonne() {
    }

    @Test
    void isChampManquant() {
        assertEquals(false, concours.isChampManquant());
    }
}