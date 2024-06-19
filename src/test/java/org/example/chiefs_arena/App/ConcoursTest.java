package org.example.chiefs_arena.App;
import org.example.chiefs_arena.exception.ChampNonSaisie;
import org.example.chiefs_arena.exception.ConcoursDateInvalide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcoursTest {
    private Concours concours;
    private Concours concours2;
    @BeforeEach
    void setUp() {
        concours = new Concours();
        concours.setNom("CookTempest");
        concours.setDescription("Evénement culinaire sur la cuisine française");
        concours.setDateDebut(new Date(2024, Calendar.AUGUST, 8, 14, 0 , 0));
        concours.setDateFin(new Date(2024, Calendar.AUGUST, 8, 18, 0 , 0));
        concours.setLieu(new Lieu("Castilla", 70));

        concours2 = new Concours();
        concours2.setNom("CookContest");
        concours2.setDateDebut(new Date(2024, Calendar.AUGUST, 20, 14, 0 , 0));
        concours2.setLieu(new Lieu("Menlack",110));
    }
    @Test
    void setNom() {
        assertEquals("CookTempest", concours.getNom());
        assertEquals("CookContest", concours2.getNom());
    }
    @Test
    void setDescription() {
        assertEquals("Evénement culinaire sur la cuisine française", concours.getDescription());
        assertNull(concours2.getDescription());
    }

    @Test
    void setDateDebut() {
        assertEquals(new Date(2024, Calendar.AUGUST, 8, 14, 0 , 0),concours.getDateDebut());
        assertEquals(new Date(2024, Calendar.AUGUST, 20, 14, 0 , 0),concours2.getDateDebut());
    }

    @Test
    void setDateFin() {
        assertEquals(new Date(2024, Calendar.AUGUST, 8, 18, 0 , 0), concours.getDateFin());
        assertNull(concours2.getDateFin());
    }

    @Test
    void setLieu() {
        assertEquals("Castilla", concours.getLieu().getNom());
        assertEquals(70, concours.getLieu().getCapacite());
        assertEquals("Menlack", concours2.getLieu().getNom());
        assertEquals(110, concours2.getLieu().getCapacite());
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
        assertTrue(concours2.isChampManquant());
        concours.setNom(null);
        assertTrue(concours.isChampManquant());
    }

    @Test
    public void testChampsObligatoiresNonSaisis() {
        concours.setNom(null);

        Exception exception = assertThrows(ChampNonSaisie.class, () -> {
            concours.checkChampsSaisie();
        });

        assertEquals("Un champ obligatoire n'a pas été saisi.", exception.getMessage());
    }
}