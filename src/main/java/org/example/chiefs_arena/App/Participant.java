package org.example.chiefs_arena.App;

import java.util.List;

public class Participant extends Personne {
    private Jury jury;

    public Participant(int id, String nom, String prenom, int age, String role) {
        super(id, nom, prenom, age, role);
    }

    public List<Note> getNotesJury(){
        return jury.getNotes();
    }

}