package org.example.chiefs_arena;

public class Partenaire {
    private String id;
    private String nom;
    private String contribution;
    private String contraintes;

    public Partenaire(String id, String nom, String contribution, String contraintes) {
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

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getContraintes() {
        return contraintes;
    }

    public void setContraintes(String contraintes) {
        this.contraintes = contraintes;
    }
}

