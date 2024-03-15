package Chateau;

import Couleur.Couleur;
import Personnages.Guerrier;

import java.util.ArrayList;

public class Chateau {
    //attributs
    private final int RESSOURCES_INITIAL = 3;
    private final int AJOUTEE_PAR_TOUR = 1;
    private int ressources;
    private final Couleur c;

    //Constructors
    public Chateau(Couleur couleur) {
        c=couleur;
    }

    //Méthodes
    public void ajoutGuerrierNovice(Guerrier guerrier){

    }
//    public ArrayList<Guerrier> getGuerriersNovice(){
//
//    }
//
//    public ArrayList<Guerrier> entrainer(){
//
//    }

    private void incrementerRessources(){

    }

    public Couleur getCouleur(){
        return this.c;
    }

    public boolean estBleu(){
        return c.getCouleur().equals("bleu");
    }

    public boolean estRouge(){
        return c.getCouleur().equals("rouge");
    }
}
