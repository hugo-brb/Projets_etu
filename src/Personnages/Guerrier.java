package Personnages;

import Plateau.Chateau;
import Couleur.Couleur;

/**
 * Cette classe permet de définir un guerrier de base
 * Les guerrier ont par défaut :
 *          - 10 de force
 *          - 100 de points de vie
 */
public class Guerrier {
    //attributs
    private final int FORCE_BASE = 10;
    private final int PV_MAX_BASE = 100;
    private final int RESSOURCE_BASE = 1;
    private int pointsDeVie;
    private Couleur c;
    private Chateau cha;

    //Constructors
    public Guerrier(){
        setPointsDeVie(100);
    }
    //Méthodes
    public int getForce(){
        return this.FORCE_BASE;
    }
    public int getPointsDeVie(){
        return this.pointsDeVie;
    }
    public int getRessourcesPourEntrainement(){ return RESSOURCE_BASE; }
    public Couleur getCouleur(){ return c; }
    public void setPointsDeVie(int pointsDeVie){
        this.pointsDeVie = pointsDeVie;
    }

    /**
     * Cette méthode permet de connaître l'état d'un Guerrier
     * @return true si PointDeVie > 0 | false si PointDeVie <= 0
     */
    public boolean estVivant(){
        return getPointsDeVie()>0;
    }

    /**
     * Cette méthode permet d'utiliser la valeur de la force d'un Guerrier pour attaquer un autre Guerrier
     * @param g - Guerrier a attaquer
     */
    public void attaquer(Guerrier g){
        int d = 0;
        for (int i = 0; i < getForce(); i++) {
            d+= (int) (Math.random()*3)+1;
        }
        g.setPointsDeVie(g.getPointsDeVie()-d);
    }

    /**
     * Cette méthode permet de gerer la perte de points de vie après une attaque d'un autre Guerrier
     * @param degats - degats subit par le Guerrier
     */
    public void subirDegats(int degats){
        setPointsDeVie(getPointsDeVie()-degats);
    }
}
