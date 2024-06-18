package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategorieTest {
    @Test
    void testCategorieConstructorAndGetters() {
        List<String> sousCategories = new ArrayList<>();
        sousCategories.add("SousCat1");
        Categorie categorie = new Categorie("Catégorie A", sousCategories);
        assertEquals("Catégorie A", categorie.getNom());
        assertEquals(sousCategories, categorie.getSousCategories());
    }

    @Test
    void testSetNom(){
        List<String> sousCategories = new ArrayList<>();
        Categorie categorie = new Categorie("Catégorie A", sousCategories);
        categorie.setNom("Catégorie B");
        assertEquals("Catégorie B", categorie.getNom());
    }

    @Test
    void testSetSousCategorie(){
        List<String> sousCategories = new ArrayList<>();
        Categorie categorie = new Categorie("Catégorie A", sousCategories);
        List<String> newSousCategories = new ArrayList<>();
        newSousCategories.add("SousCat2");
        categorie.setSousCategories(newSousCategories);
        assertEquals(newSousCategories, categorie.getSousCategories());
    }
}
