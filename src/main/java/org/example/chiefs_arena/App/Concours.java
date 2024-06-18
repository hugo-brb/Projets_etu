package org.example.chiefs_arena.App;

import java.util.Date;
import java.util.List;

public class Concours {
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Lieu lieu;
    private Classement classement;
    private List<Categorie> categories;
    private List<Partenaire> partenaires;


    private List<Personne> participants;

    public Concours(String nom, String description, Date dateDebut, Date dateFin, Lieu lieu, Classement classement, List<Categorie> categories, List<Partenaire> partenaires, List<Personne> participants) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
        this.classement = classement;
        this.categories = categories;
        this.partenaires = partenaires;
        this.participants = participants;
    }

    public Classement getClassement()
    {
        return classement;
    }

    public List<Categorie> getCategories()
    {
        return categories;
    }

    public List<Partenaire> getPartenaires()
    {
        return partenaires;
    }

    public List<Personne> getParticipants()
    {
        return participants;
    }

    public void setParticipants(List<Personne> participants)
    {
        this.participants = participants;
    }

    public void setPartenaires(List<Partenaire> partenaires)
    {
        this.partenaires = partenaires;
    }

    public void setCategories(List<Categorie> categories)
    {
        this.categories = categories;
    }

    public void setClassement(Classement classement)
    {
        this.classement = classement;
    }

    public Concours(String nom, Date dateDebut, Date dateFin) {
        setNom(nom);
        setDateDebut(dateDebut);
        setDateFin(dateFin);
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
     * @return nom == null | dateDebut == null | dateFin == null | lieu == null | categories.isEmpty();
     */
    public boolean isChampManquant() {
        return nom == null | dateDebut == null | dateFin == null | lieu == null | categories.isEmpty();
    }


}

