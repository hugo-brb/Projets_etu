package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @Test
    void testParticipantConstructorAndGetters() {
        Participant participant = new Participant(1, "Durand", "John", 25, "participant");
        assertEquals(1, participant.getId());
        assertEquals("Durand", participant.getNom());
        assertEquals("John", participant.getPrenom());
        assertEquals(25, participant.getAge());
        assertEquals("participant", participant.getRole());
    }
}
