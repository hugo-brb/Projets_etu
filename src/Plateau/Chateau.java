package Plateau;

import Couleur.Couleur;
import Personnages.Guerrier;

import java.util.ArrayList;

public class Chateau {
    //attributs
    private final int RESSOURCES_INITIAL = 3;
    private final int AJOUTEE_PAR_TOUR = 1;
    private int ressources;
    private final Couleur c;

    private ArrayList<Guerrier> lesGuerriersNovice;
    private ArrayList<Guerrier> lesGuerriersEntrainer;

    //Constructors
    public Chateau(Couleur couleur) {
        c=couleur;
    }

    //Méthodes
    public void ajoutGuerrierNovice(Guerrier guerrier){

    }
    public ArrayList<Guerrier> getGuerriersNovice(){
        return lesGuerriersNovice;
    }

    public ArrayList<Guerrier> entrainer(){
        int i = 0;
        while (ressources != 0 || i < lesGuerriersNovice.size() ){
            lesGuerriersNovice.get(i).setEstEntrainer(true);
            lesGuerriersEntrainer.add(lesGuerriersNovice.get(i));
            lesGuerriersNovice.remove(lesGuerriersNovice.get(i));
            i++;
        }
        return lesGuerriersEntrainer;
    }

    private void incrementerRessources(){
        this.ressources += AJOUTEE_PAR_TOUR;
    }

    public Couleur getCouleur(){
        return this.c;
    }

    public boolean estBleu(){
        return c.getCouleur().equalsIgnoreCase("bleu");
    }

    public boolean estRouge(){
        return c.getCouleur().equalsIgnoreCase("rouge");
    }
}
