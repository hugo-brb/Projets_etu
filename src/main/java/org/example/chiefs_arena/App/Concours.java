package org.example.chiefs_arena.App;

import org.example.chiefs_arena.exception.ChampNonSaisie;
import org.example.chiefs_arena.exception.ConcoursDateInvalide;
import org.example.chiefs_arena.exception.ConcoursDejaExistant;
import org.example.chiefs_arena.exception.DescriptionTropLongue;

import java.time.*;
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

    public Concours() throws ConcoursDejaExistant, ConcoursDateInvalide {
        /*setNom(getNom());
        setDateDebut(getDateDebut());
        setDateFin(getDateFin());
        setLieu(getLieu());
        /*Pas nécessaire*/
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

    public void setDescription(String description) throws DescriptionTropLongue {
        if(description.length() > 1000){
            throw new DescriptionTropLongue("Votre description doit contenir moins de 1000 caractères.");
        }
        this.description = description;
    }

    public Date getDateDebut(){
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) throws ConcoursDateInvalide{
        if(dateDebut.toInstant().atZone(ZoneId.of("Europe/Paris")).isBefore(ZonedDateTime.now(Clock.system(ZoneId.of("Europe/Paris"))))){
            throw new ConcoursDateInvalide("La date est déjà passée");
        }
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) throws ConcoursDateInvalide {
        if(dateFin.toInstant().isBefore(dateDebut.toInstant())){
            throw new ConcoursDateInvalide("La fin du concours ne peut pas être avant le début.");
        }
        this.dateFin = dateFin;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
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

