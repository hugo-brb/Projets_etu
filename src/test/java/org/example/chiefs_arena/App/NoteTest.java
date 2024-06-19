package org.example.chiefs_arena.App;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests unitaires pour la classe Note.
 */
public class NoteTest {
    private Note note1 = new Note();
    private Note note2 = new Note();
    private Note note3 = new Note();

    /**
     * Initialise un objet Note avant chaque test.
     */
    @BeforeEach
    public void setUp(){
        note1.setNote(10);
        note2.setNote(15);
        note3.setNote(0);
    }

    /**
     * Teste la méthode setGetNote().
     */
    @Test
    public void testSetGetNote(){
        assertEquals(10, note1.getNote());

    }
}

