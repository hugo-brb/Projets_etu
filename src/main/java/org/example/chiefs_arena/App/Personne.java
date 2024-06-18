package org.example.chiefs_arena.App;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String role;

    public Personne(int id, String nom, String prenom, int age, String role) {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setAge(age);
        setRole(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}