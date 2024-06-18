package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        assertEquals("Castilla", concours.getLieu().getNom());
        assertEquals(70, concours.getLieu().getCapacite());
    }

    @Test
    void ajouterCategorie() {
        Categorie categorie = new Categorie("Age", List.of("Junior", "Senior"));
        concours.ajouterCategorie(categorie);
        assertTrue(concours.getCategories().contains(categorie));
    }

    @Test
    void ajouterPartenaire() {
        Partenaire partenaire = new Partenaire("1", "Sponsor", 1000, "Aucune");
        concours.ajouterPartenaire(partenaire);
        assertTrue(concours.getPartenaires().contains(partenaire));
    }

    @Test
    void ajouterPersonne() {
        Personne personne = new Personne(1, "Durand", "John", 25, "Participant");
        concours.ajouterPersonne(personne);
        assertTrue(concours.getPersonnes().contains(personne));
    }

    @Test
    void isChampManquant() {
        assertFalse(concours.isChampManquant());
        concours.setNom(null);
        assertTrue(concours.isChampManquant());
    }
}