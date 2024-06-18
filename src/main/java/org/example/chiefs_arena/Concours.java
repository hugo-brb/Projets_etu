package org.example.chiefs_arena;
import java.util.Date;
import java.util.List;

public class Concours {
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;

    private List<Categorie> categories;
    private List<Partenaire> partenaires;
    private List<Personne> personnes;

    public Concours(String nom, Date dateDebut, Date dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    public void ajouterPartenaire(Partenaire partenaire) {
        partenaires.add(partenaire);
    }

    public void ajouterPersonne(Personne personne) {
        personnes.add(personne);
    }

    public boolean isChampionnant() {
        // Logique pour déterminer si c'est un championnat
        return true;
    }
}

