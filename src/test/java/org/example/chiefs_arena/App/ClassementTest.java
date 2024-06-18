package org.example.chiefs_arena.App;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassementTest {
    @Test
    void testClassementConstructorAndGetters() {
        Classement classement = new Classement();
        classement.setPosition(1);
        assertEquals(1, classement.getPosition());

        List<Participant> podium = new ArrayList<>();
        Participant participant = new Participant(1, "John", "Durand", 25, "participant");
        podium.add(participant);
        classement.setPodium(podium);
        assertEquals(podium, classement.getPodium());
    }

    @Test
    void testSetPosition() {
        Classement classement = new Classement();
        classement.setPosition(2);
        assertEquals(2, classement.getPosition());
    }

    @Test
    void testSetPodium() {
        Classement classement = new Classement();
        List<Participant> podium = new ArrayList<>();
        Participant participant = new Participant(1, "John", "Durand", 25, "participant");
        podium.add(participant);
        classement.setPodium(podium);
        assertEquals(podium, classement.getPodium());
    }
}
