package org.example.chiefs_arena.App;

import java.util.List;

/**
 * Représente le classement des participants dans un concours.
 */
public class Classement {
    private int position;
    private List<Participant> podium;

    public Classement() {}

    public Classement(int position, List<Participant> podium)
    {
        this.position = position;
        this.podium = podium;
    }

    /**
     * Obtient la position du classement.
     *
     * @return La position du classement.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Définit la position du classement.
     *
     * @param position La nouvelle position du classement.
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Obtient la liste des participants sur le podium.
     *
     * @return La liste des participants sur le podium.
     */
    public List<Participant> getPodium() {
        return podium;
    }

    /**
     * Définit la liste des participants sur le podium.
     *
     * @param podium La nouvelle liste des participants sur le podium.
     */
    public void setPodium(List<Participant> podium) {
        this.podium = podium;
    }
}
