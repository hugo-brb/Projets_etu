package Plateau;

import Couleur.Couleur;
import Personnages.Guerrier;

import java.util.ArrayList;

public class Plateau {
    //Attributs
    private int longueur;

    //Constructors
    public Plateau(int longeur){
        this.longueur = longueur;
    }

    //Méthodes
    public void ajoutGuerriers(Chateau chateau, ArrayList<Guerrier> guerriers){
        for (Guerrier g:
             guerriers) {
            chateau.ajoutGuerrierNovice(g);
        }
    }

    public void deplaceGuerriers(){

    }

    public void lanceCombat(){

    }

    public boolean estPartieTerminee(){
        return false;
    }

    public Couleur getGagnant(){
        return new Couleur("bleu");
    }

    public ArrayList<Carreau> getCarreaux(){
        return new ArrayList<Carreau>();
    }

    public Carreau getDepartBleu(){
        return new Carreau();
    }

    public Carreau getDepartRouge(){
        return new Carreau();
    }

}
