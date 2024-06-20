package org.example.chiefs_arena.App;

import org.example.chiefs_arena.exception.ChampNonSaisie;
import org.example.chiefs_arena.exception.ConcoursDejaExistant;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Concours {
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Lieu lieu;
    private List<Categorie> categories = new ArrayList<>();
    private List<Partenaire> partenaires = new ArrayList<>();
    private List<Personne> participants = new ArrayList<>();
    private Classement classement;

    public Concours() throws ConcoursDejaExistant {
        setNom(getNom());
        setDateDebut(getDateDebut());
        setDateFin(getDateFin());
        setLieu(getLieu());
        /*Pas nécessaire*/
    }

    public Concours(String nom, String description, Date dateDebut, Date dateFin, Lieu lieu, List<Categorie> categories, List<Partenaire> partenaires, List<Personne> participants, Classement classement)
    {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
        this.categories = categories;
        this.partenaires = partenaires;
        this.participants = participants;
        this.classement = classement;
    }

    public void setCategories(List<Categorie> categories)
    {
        this.categories = categories;
    }

    public void setPartenaires(List<Partenaire> partenaires)
    {
        this.partenaires = partenaires;
    }

    public void setParticipants(List<Personne> participants)
    {
        this.participants = participants;
    }

    public void setClassement(Classement classement)
    {
        this.classement = classement;
    }

    public List<Personne> getParticipants()
    {
        return participants;
    }

    public Classement getClassement()
    {
        return classement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ConcoursDejaExistant {
        if (this.nom != null && this.nom.equals(nom)) {
            throw new ConcoursDejaExistant("Le nom de l'événement est déjà utilisé.");
        }
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
    public List<Partenaire> getPartenaires() {
        return partenaires;
    }

    public List<Personne> getPersonnes() {
        return participants;
    }

    public List<Categorie> getCategories() {
        return categories;
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


    /**
     * Renvoie vrai s'il un de ces champs est manquant. Ils sont obligatoires pour créer un événement
     * @return nom == null | dateDebut == null | dateFin == null | lieu == null;
     */
    public boolean isChampManquant() {
        return nom == null || dateDebut == null || dateFin == null || lieu == null;
    }

    /**
     *     Méthode pour vérifier les champs obligatoires
     */
    public void checkChampsSaisie() throws ChampNonSaisie {
        if (isChampManquant()) {
            throw new ChampNonSaisie("Un champ obligatoire n'a pas été saisi.");
        }
    }


}

