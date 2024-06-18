package org.example.chiefs_arena.App;
import java.util.List;


/**
 * Représente un membre du jury dans un concours.
 */
public class Jury extends Personne {
    private List<Note> notes;

    /**
     * Constructeur de la classe Jury.
     *
     * @param id L'identifiant du membre du jury.
     * @param nom Le nom du membre du jury.
     * @param prenom Le prénom du membre du jury.
     * @param age L'âge du membre du jury.
     * @param role Le rôle du membre du jury (toujours "jury").
     */
    public Jury(int id, String nom, String prenom, int age, String role) {
        super(id, nom, prenom, age, role);
    }

    /**
     * Obtient la liste des notes attribuées par le membre du jury.
     *
     * @return La liste des notes attribuées par le membre du jury.
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * Définit la liste des notes attribuées par le membre du jury.
     *
     * @param notes La nouvelle liste des notes attribuées par le membre du jury.
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
