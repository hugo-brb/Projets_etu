package org.example.chiefs_arena.App;

import java.util.List;

/**
 * Représente un participant à un concours.
 * Un participant est une personne qui posséde une liste de notes données par chaque membre du jury.
 */

public class Participant extends Personne {
    private Jury jury;

    public Participant(int id, String nom, String prenom, int age, String role) {
        super(id, nom, prenom, age, role);
    }

    /**
     * Obtient les notes attribuées au participant par le Jury.
     * @return la liste de notes données par le jury.
     */

    public List<Note> getNotesJury(){
        return jury.getNotes();
    }

}