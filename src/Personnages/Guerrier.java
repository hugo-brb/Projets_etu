package Personnages;

import Couleur.Couleur;
import Plateau.Chateau;

/**
 * Cette classe permet de définir un guerrier de base.
 * Les guerriers ont par défaut :
 * - 10 de force
 * - 100 points de vie
 */
public class Guerrier {
    // Attributs
    private final int FORCE_BASE = 10;
    private final int PV_MAX_BASE = 100;
    private final int RESSOURCE_BASE = 1;
    private int pointsDeVie;
    private int nbRessources = 0;
    private boolean estEntrainer;
    private Chateau cha;

    // Constructeurs
    public Guerrier() {
        setPointsDeVie(100);
        this.estEntrainer = false;
    }

    // Méthodes

    /**
     * Renvoie la force de ce guerrier.
     *
     * @return la force de ce guerrier
     */
    public int getForce() {
        return this.FORCE_BASE;
    }

    /**
     * Renvoie les points de vie actuels de ce guerrier.
     *
     * @return les points de vie actuels de ce guerrier
     */
    public int getPointsDeVie() {
        return this.pointsDeVie;
    }

    /**
     * Renvoie le coût en ressources pour entraîner ce guerrier.
     *
     * @return le coût en ressources pour entraîner ce guerrier
     */
    public int getRessourcesPourEntrainement() {
        return RESSOURCE_BASE;
    }

    /**
     * Renvoie la couleur du château à laquelle ce guerrier est affilié.
     *
     * @return la couleur du château à laquelle ce guerrier est affilié
     */
    public Couleur getCouleur() {
        return cha.getCouleur();
    }

    /**
     * Définit les points de vie de ce guerrier.
     *
     * @param pointsDeVie les nouveaux points de vie à définir
     */
    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    /**
     * Définit le château auquel ce guerrier est affilié.
     *
     * @param c le nouveau château auquel ce guerrier est affilié
     */
    public void setChateau(Chateau c) {
        this.cha = c;
    }

    /**
     * Définit si ce guerrier est entraîné ou non.
     *
     * @param b true si ce guerrier est entraîné, false sinon
     */
    public void setEstEntrainer(boolean b) {
        this.estEntrainer = b;
    }

    /**
     * Vérifie si ce guerrier est encore en vie.
     *
     * @return true si les points de vie de ce guerrier sont supérieurs à 0, false sinon
     */
    public boolean estVivant() {
        return getPointsDeVie() > 0;
    }

    /**
     * Vérifie si ce guerrier est affilié à la couleur bleue.
     *
     * @return true si ce guerrier est affilié à la couleur bleue, false sinon
     */
    public boolean estBleu() {
        return cha.estBleu();
    }

    /**
     * Vérifie si ce guerrier est affilié à la couleur rouge.
     *
     * @return true si ce guerrier est affilié à la couleur rouge, false sinon
     */
    public boolean estRouge() {
        return cha.estRouge();
    }

    /**
     * Attaque un autre guerrier en infligeant des dégâts basés sur la force de ce guerrier.
     *
     * @param g le guerrier à attaquer
     */
    public void attaquer(Guerrier g) {
        int d = 0;
        for (int i = 0; i < getForce(); i++) {
            d += (int) (Math.random() * 3) + 1;
        }
        g.setPointsDeVie(g.getPointsDeVie() - d);
    }

    /**
     * Subit des dégâts infligés par un autre guerrier.
     *
     * @param degats les dégâts infligés à ce guerrier
     */
    public void subirDegats(int degats) {
        setPointsDeVie(getPointsDeVie() - degats);
    }

    /**
     * Renvoie le nombre de ressources possédées par ce guerrier.
     *
     * @return le nombre de ressources possédées par ce guerrier
     */
    public int getNbRessources() {
        return nbRessources;
    }

    /**
     * Définit le nombre de ressources possédées par ce guerrier.
     *
     * @param ressources le nombre de ressources à définir
     */
    public void setNbRessources(int ressources) {
        this.nbRessources += ressources;
    }
}