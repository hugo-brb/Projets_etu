package org.example.chiefs_arena.App;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests unitaires pour la classe Jury.
 */
public class JuryTest {
    private Jury jury;
    private Note note1;
    private Note note2;

    /**
     * Initialise un objet Jury avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        jury = new Jury(1, "Durand", "John", 35, "Jury");
        note1 = new Note();
        note1.setNote(8);
        note2 = new Note();
        note2.setNote(9);
    }

    /**
     * Teste la méthode setGetNotes().
     */
    @Test
    public void testSetGetNotes() {
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        jury.setNotes(notes);
        assertEquals(notes, jury.getNotes());
    }
}

