package Plateau;

import Personnages.Guerrier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarreauTest {

    @Test
    void getGuerriersBleus() {
        Carreau carreau = new Carreau();

        ArrayList<Guerrier> guerriersBleus = new ArrayList<>();
        guerriersBleus.add(new Guerrier());
        guerriersBleus.add(new Guerrier());

        carreau.ajoutGuerriersBleus(guerriersBleus);

        assertEquals(guerriersBleus, carreau.getGuerriersBleus());
    }

    @Test
    void getGuerriersRouges() {
        Carreau carreau = new Carreau();

        ArrayList<Guerrier> guerriersRouges = new ArrayList<>();
        guerriersRouges.add(new Guerrier());
        guerriersRouges.add(new Guerrier());

        carreau.ajoutGuerriersRouge(guerriersRouges);

        assertEquals(guerriersRouges, carreau.getGuerriersRouges());
    }

    @Test
    void ajoutGuerriersBleus() {
        Carreau carreau = new Carreau();

        ArrayList<Guerrier> guerriersBleus = new ArrayList<>();
        guerriersBleus.add(new Guerrier());

        carreau.ajoutGuerriersBleus(guerriersBleus);

        assertTrue(carreau.haveBlue());
    }

    @Test
    void ajoutGuerriersRouge() {
        Carreau carreau = new Carreau();

        ArrayList<Guerrier> guerriersRouges = new ArrayList<>();
        guerriersRouges.add(new Guerrier());

        carreau.ajoutGuerriersRouge(guerriersRouges);

        assertTrue(carreau.haveRed());
    }

    @Test
    void haveBlue() {
        Carreau carreau = new Carreau();
        assertFalse(carreau.haveBlue());
    }

    @Test
    void haveRed() {
        Carreau carreau = new Carreau();
        assertFalse(carreau.haveRed());
    }
}
