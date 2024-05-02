package Plateau;

import Couleur.Couleur;
import Personnages.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChateauTest {

    @Test
    void ajoutGuerrierNovice() {
        Chateau chateau = new Chateau(new Couleur("bleu"));
        Guerrier guerrier = new Guerrier();
        chateau.ajoutGuerrierNovice(guerrier);

        assertTrue(chateau.getGuerriersNovice().contains(guerrier));
    }

    @Test
    void getGuerriersNovice() {
        Chateau chateau = new Chateau(new Couleur("rouge"));
        ArrayList<Guerrier> guerriers = chateau.getGuerriersNovice();

        assertNotNull(guerriers);
        assertNotEquals(0, guerriers.size());
    }

    @Test
    void estBleu() {
        Chateau chateauBleu = new Chateau(new Couleur("bleu"));
        assertTrue(chateauBleu.estBleu());

        Chateau chateauRouge = new Chateau(new Couleur("rouge"));
        assertFalse(chateauRouge.estBleu());
    }

    @Test
    void estRouge() {
        Chateau chateauBleu = new Chateau(new Couleur("bleu"));
        assertFalse(chateauBleu.estRouge());

        Chateau chateauRouge = new Chateau(new Couleur("rouge"));
        assertTrue(chateauRouge.estRouge());
    }

    @Test
    void getRessources() {
        Chateau chateau = new Chateau(new Couleur("bleu"));
        assertEquals(3, chateau.getRessources());
    }
}
