package Personnages;

import Couleur.Couleur;
import Plateau.Chateau;

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
    private int nbRessources = 0;

    private boolean estEntrainer;
    private Chateau cha;

    //Constructors
    public Guerrier(){
        setPointsDeVie(100);
        this.estEntrainer = false;
    }
    //Méthodes
    public int getForce(){
        return this.FORCE_BASE;
    }
    public int getPointsDeVie(){
        return this.pointsDeVie;
    }
    public int getRessourcesPourEntrainement(){ return RESSOURCE_BASE; }
    public Couleur getCouleur(){ return cha.getCouleur(); }
    public void setPointsDeVie(int pointsDeVie){
        this.pointsDeVie = pointsDeVie;
    }
    public void setChateau(Chateau c){
        this.cha = c;
    }
    public void setEstEntrainer (boolean b) { this.estEntrainer = b;}

    /**
     * Cette méthode permet de connaître l'état d'un Guerrier
     * @return true si PointDeVie > 0 | false si PointDeVie <= 0
     */
    public boolean estVivant(){
        return getPointsDeVie()>0;
    }

    /**
     * Ces méthodes permet de connaître la couleur d'un Guerrier
     */
    public boolean estBleu(){
        return cha.estBleu();
    }
    public boolean estRouge(){
        return cha.estRouge() ;
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

    public int getNbRessources() {
        return nbRessources;
    }

    public void setNbRessources(int ressources) {
        this.nbRessources += ressources;
    }
}
