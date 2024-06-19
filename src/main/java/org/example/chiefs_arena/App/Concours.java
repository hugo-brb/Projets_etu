package org.example.chiefs_arena.App;

import java.util.Date;
import java.util.List;

public class Concours {
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Lieu lieu;
    private List<Categorie> categories;
    private List<Partenaire> partenaires;
    private List<Personne> participants;
    private Classement classement;

    public Concours() {
        setNom(getNom());
        setDateDebut(getDateDebut());
        setDateFin(getDateFin());
        setLieu(getLieu());
        /*Pas nécessaire*/
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

    public Lieu getLieu() {
        return lieu;
    }
    
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }

    public void ajouterPartenaire(Partenaire partenaire) {
        partenaires.add(partenaire);
    }

    public void ajouterPersonne(Personne personne) {
        participants.add(personne);
    }

    public boolean isChampionnant() {
        // Logique pour déterminer si c'est un championnat
        return true;
    }
    /**
     * Renvoie vrai s'il un de ces champs est manquant. Ils sont obligatoires pour créer un événement
     * @return nom == null | dateDebut == null | dateFin == null | lieu == null;
     */
    public boolean isChampManquant() {
        return nom == null || dateDebut == null || dateFin == null || lieu == null;
    }



}

