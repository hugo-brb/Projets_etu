package org.example.chiefs_arena.App;

import org.example.chiefs_arena.exception.*;

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

    public Concours() throws ConcoursDejaExistant, ConcoursDateInvalide {
        /*setNom(getNom());
        setDateDebut(getDateDebut());
        setDateFin(getDateFin());
        setLieu(getLieu());
        /*Pas nécessaire*/
    }


    public List<Personne> getParticipants()
    {
        return participants;
    }

    public Classement getClassement()
    {
        return classement;
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

    /**
     * Obtient le nom du concours.
     * @return Le nom du concours.
     */
    public String getNom() {
        return nom;
    }


    /**
     * Définit le nom du concours.
     * Exception: Scénario alternatif 1 - Evénement déjà existant
     * Si l'utilisateur donne comme nom d'événement un nom déjà utilisé, la plateforme retourne un message d'erreur
     * @param nom Le nom donné au concours
     * @throws ConcoursDejaExistant Exception
     */

    public void setNom(String nom) throws ConcoursDejaExistant {
        if (this.nom != null && this.nom.compareTo(nom) == 0) {
            throw new ConcoursDejaExistant("Le nom de l'événement est déjà utilisé.");
        }
        this.nom = nom;
    }
    /**
     * Obtient la description du concours.
     * @return La description du concours.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Définit le nom du concours.
     * Exception: Scénario alternatif 1 - Description trop longue de l'événement
     * Si l'utilisateur décide de donner une description d'événement de plus de 1000 caractères.
     * Un message d'erreur informe l'utilisateur que la description ne peut pas dépasser 1000 caractères.
     * @param description La description du concours
     * @throws DescriptionTropLongue Exception
     */
    public void setDescription(String description) throws DescriptionTropLongue {
        if(description.length() > 1000){
            throw new DescriptionTropLongue("Votre description doit contenir moins de 1000 caractères.");
        }
        this.description = description;
    }

    /**
     * Obtient la date de début du concours.
     * @return La date de début du concours.
     */
    public Date getDateDebut(){
        return dateDebut;
    }

    /**
     * Définit la date de début d'un concours
     * Exception: Scénario alternatif 1 - Date de l'événement invalide
     * Si l'utilisateur saisit une date qui est antérieure à celle d'aujourd'hui. La saisie est refusée avec un
     * message d'erreur indiquant que la date est déjà passée.
     * @param dateDebut La date de début des concours.
     * @throws ConcoursDateInvalide Exception
     */

    public void setDateDebut(Date dateDebut) throws ConcoursDateInvalide{
        if(dateDebut.toInstant().atZone(ZoneId.of("Europe/Paris")).isBefore(ZonedDateTime.now(Clock.system(ZoneId.of("Europe/Paris"))))){
            throw new ConcoursDateInvalide("La date est déjà passée");
        }
        this.dateDebut = dateDebut;
    }
    /**
     * Obtient la date de fin du concours .
     * @return La date de fin du concours.
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Définit la date de fin d'un concours
     * Exception: Scénario alternatif 1 - Date de l'événement invalide
     * Si l'utilisateur saisit une date qui est antérieure à la date de début du concours. La saisie est refusée
     * avec un message d'erreur indiquant que la date de fin ne peut pas être avant le début.
     * @param dateFin La date de fin du concours
     * @throws ConcoursDateInvalide Exception
     */

    public void setDateFin(Date dateFin) throws ConcoursDateInvalide {
        if(dateFin.toInstant().isBefore(dateDebut.toInstant())){
            throw new ConcoursDateInvalide("La fin du concours ne peut pas être avant le début.");
        }
        this.dateFin = dateFin;
    }
    /**
     * Obtient le lieu du concours.
     * @return Le lieu du concours.
     */
    public Lieu getLieu() {
        return lieu;
    }

    /**
     *
     * @param lieu
     * @throws ConcoursLieuIdentique
     */

    public void setLieu(Lieu lieu) throws ConcoursLieuIdentique {
        this.lieu = lieu;
        /*if(dateDebut.toInstant().isBefore(dateFin.toInstant()) && (lieu.getNom().compareTo(getLieu().getNom()) == 0)){
            throw new ConcoursLieuIdentique("Un autre concours a déjà lieu à cet endroit.");
        }*/
    }
    /**
     * Obtient le nom du concours.
     * @return Le nom du concours.
     */
    public List<Partenaire> getPartenaires() {
        return partenaires;
    }
    /**
     * Obtient le nom du concours.
     * @return Le nom du concours.
     */
    public List<Personne> getPersonnes() {
        return participants;
    }
    /**
     * Obtient le nom du concours.
     * @return Le nom du concours.
     */

    public List<Categorie> getCategories() {
        return categories;
    }

    /**
     * Ajoute la catégorie passée en paramètre à la liste de catégories.
     * @param categorie
     */

    public void ajouterCategorie(Categorie categorie) {
        categories.add(categorie);
    }
    /**
     * Ajoute le partenaire (sponsor de l'événement) passé en paramètre à la liste de partenaires.
     * @param partenaire
     */
    public void ajouterPartenaire(Partenaire partenaire) {
        partenaires.add(partenaire);
    }
    /**
     * Ajoute la personne passée en paramètre à la liste de participants.
     * @param personne
     */
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

