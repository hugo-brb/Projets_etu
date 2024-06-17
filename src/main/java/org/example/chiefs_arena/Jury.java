package org.example.chiefs_arena;
import java.util.List;

public class Jury extends Personne {
    private List<Note> notes;

    public Jury(int id, String nom, String prenom, int age, String role) {
        super(id, nom, prenom, age, role);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
