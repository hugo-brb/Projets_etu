package org.example.chiefs_arena.App;
import java.util.List;

/**
 * Représente une catégorie de concours.
 */
public class Categorie {
    private String nom;
    private List<String> sousCategories;

    /**
     * Constructeur de la classe Categorie.
     *
     * @param nom Le nom de la catégorie.
     * @param sousCategories La liste des sous-catégories.
     */
    public Categorie(String nom, List<String> sousCategories) {
        this.nom = nom;
        this.sousCategories = sousCategories;
    }

    /**
     * Obtient le nom de la catégorie.
     *
     * @return Le nom de la catégorie.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la catégorie.
     *
     * @param nom Le nouveau nom de la catégorie.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient la liste des sous-catégories.
     *
     * @return La liste des sous-catégories.
     */
    public List<String> getSousCategories() {
        return sousCategories;
    }

    /**
     * Définit la liste des sous-catégories.
     *
     * @param sousCategories La nouvelle liste des sous-catégories.
     */
    public void setSousCategories(List<String> sousCategories) {
        this.sousCategories = sousCategories;
    }
}
