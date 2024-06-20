package org.example.chiefs_arena.App;

/**
 * Représente une personne et ses caractéristique.
 * Une personne est soit un membre du jury, soit un participant à un concours.
 */

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String role;

    /**
     * Constructeur de la classe Personne
     * @param id le numéro d'identification de la personne
     * @param nom le nom de la personne
     * @param prenom le prénom de la personne
     * @param age l'âge de la personne
     * @param role le rôle de la personne : "Participant" | "Jury"
     */

    public Personne(int id, String nom, String prenom, int age, String role) {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setAge(age);
        setRole(role);
    }

    /**
     * Obtient l'id de la personne
     * @return le numéro d'identification
     */

    public int getId() {
        return id;
    }
    /**
     * Définit le numéro d'identification d'une personne
     * @param id le numéro d'identification de la personne
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le nom de la personne
     * @return le nom de la personne
     */
    public String getNom() {
        return nom;
    }
    /**
     * Définit le nom d'une personne
     * @param nom le nom de la personne
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom de la personne
     * @return le prénom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom d'une personne
     * @param prenom le prénom de la personne
     */

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtient le nom de la personne
     * @return l'âge de la personne
     */
    public int getAge() {
        return age;
    }

    /**
     * Définit l'âge d'une personne
     * @param age l'âge de la personne
     */

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Obtient le nom de la personne
     * @return le nom de la personne
     */
    public String getRole() {
        return role;
    }

    /**
     * Définit le rôle d'une personne
     * @param role le rôle de la personne
     */

    public void setRole(String role) {
        this.role = role;
    }
}