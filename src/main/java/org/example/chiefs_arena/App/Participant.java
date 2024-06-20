package org.example.chiefs_arena.App;

import java.util.List;

public class Participant extends Personne {
    private Jury jury;

    public Participant(int id, String nom, String prenom, int age) {
        super(id, nom, prenom, age, "participant");
    }

    public List<Note> getNotesJury(){
        return jury.getNotes();
    }

}