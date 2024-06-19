package org.example.chiefs_arena.App;

import static org.junit.jupiter.api.Assertions.*;

import org.example.chiefs_arena.exception.NoteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests unitaires pour la classe Note.
 */
public class NoteTest {
    private Note note1;
    private Note note2;
    private Note note3;

    /**
     * Initialise les objets Note avant chaque test.
     */
    @BeforeEach
    public void setUp() throws org.example.chiefs_arena.exception.NoteException {
        note1 = new Note();
        note2 = new Note();
        note3 = new Note();

        note1.setNote(10);
        note3.setNote(0);
    }

    /**
     * Teste la méthode setGetNote().
     */
    @Test
    public void testSetGetNote() {
        assertEquals(10, note1.getNote());
        assertEquals(0, note3.getNote());
    }

    /**
     * Teste la méthode setNote avec une note invalide.
     */
    @Test
    public void testSetNoteException(){
        assertThrows(NoteException.class, () -> note2.setNote(15));
    }
}

