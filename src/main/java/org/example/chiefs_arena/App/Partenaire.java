package org.example.chiefs_arena.App;

/**
 * Représente un partenaire (sponsor) pour un concours.
 */

public class Partenaire {
    private String id;
    private String nom;
    private int contribution;
    private String contraintes;

    /**
     * Constructeur de la classe Partenaire
     * @param id l'id du portenaire
     * @param nom le nom du portenaire
     * @param contribution la contribution du portenaire
     * @param contraintes les contraintes données par le portenaire
     */

    public Partenaire(String id, String nom, int contribution, String contraintes) {
        this.id = id;
        this.nom = nom;
        this.contribution = contribution;
        this.contraintes = contraintes;
    }

    /**
     * Obtient l'identifiant du partenaire.
     * @return l'identifiant du partenaire pour un concours.
     */

    public String getId() {
        return id;
    }

    /**
     * Définit l'identifiant du partenaire à un concours
     * @param id l'identifiant du partenaire
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtient le nom du partenaire.
     * @return le nom du partenaire pour un concours.
     */

    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du partenaire à un concours
     * @param nom le nom du partenaire
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient la somme d'argent reversée par un partenaire qui soutient l'événement.
     * @return la somme d'argent reversée par le partenaire.
     */

    public int getContribution() {
        return contribution;
    }

    /**
     * Définit la contribution versée par le partenaire à un concours
     * @param contribution la contribution du partenaire
     */
    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    /**
     * Obtient les contraintes imposées par un partenaire à (ou aux) organisateur(s) du concours
     * @return les contraintes imposées par le partenaire
     */

    public String getContraintes() {
        return contraintes;
    }

    /**
     * Définit les contraintes du partenaire pour le (ou les) organisateur(s) du concours.
     * @param contraintes la description des contraintes.
     */
    public void setContraintes(String contraintes) {
        this.contraintes = contraintes;
    }
}

