package org.example.chiefs_arena.App;

public class Partenaire {
    private String id;
    private String nom;
    private int contribution;
    private String contraintes;

    public Partenaire(String id, String nom, int contribution, String contraintes) {
        this.id = id;
        this.nom = nom;
        this.contribution = contribution;
        this.contraintes = contraintes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    public String getContraintes() {
        return contraintes;
    }

    public void setContraintes(String contraintes) {
        this.contraintes = contraintes;
    }
}

