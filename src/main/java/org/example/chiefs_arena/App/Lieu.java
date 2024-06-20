package org.example.chiefs_arena.App;

/**
 * Représente le lieu où se passe un concours.
 */

public class Lieu {
    private String nom;
    private int capacite;

    /**
     * Constructeur de la classe Lieu
     * @param nom le nom du lieu
     * @param capacite le nombre de personnes qu'un lieu peut acceuillir
     */

    public Lieu(String nom, int capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    /**
     * Obtient le nom du lieu
     * @return le nom du lieu
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom d'un lieu
     * @param nom le nom du lieu
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient la capacité du lieu
     * @return la capacité du lieu
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Définit le capacité d'un lieu
     * @param capacite la capacité du lieu
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
