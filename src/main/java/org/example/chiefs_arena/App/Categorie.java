package org.example.chiefs_arena.App;
import java.util.List;

public class Categorie {
    private String nom;
    private List<String> sousCategories;

    public Categorie(String nom, List<String> sousCategories) {
        this.nom = nom;
        this.sousCategories = sousCategories;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getSousCategories() {
        return sousCategories;
    }

    public void setSousCategories(List<String> sousCategories) {
        this.sousCategories = sousCategories;
    }
}
