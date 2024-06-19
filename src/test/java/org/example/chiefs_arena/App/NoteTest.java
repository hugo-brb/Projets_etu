package org.example.chiefs_arena.App;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests unitaires pour la classe Note.
 */
public class NoteTest {
    private Note note;

    /**
     * Initialise un objet Note avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        note = new Note();
    }

    /**
     * Teste la méthode setGetNote().
     */
    @Test
    public void testSetGetNote() {
        note.setNote(10);
        assertEquals(10, note.getNote());
    }
}

