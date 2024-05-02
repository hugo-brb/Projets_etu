package Plateau;

import Personnages.Guerrier;

import java.util.ArrayList;

public class Carreau {
    private ArrayList<Guerrier> bleu = new ArrayList<>();
    private ArrayList<Guerrier> rouge = new ArrayList<>();

    public Carreau(){

    }

    public ArrayList<Guerrier> getGuerriersBleus(){
        return bleu;
    }

    public ArrayList<Guerrier> getGuerriersRouges(){
        return rouge;
    }

    public void ajoutGuerriersBleus(ArrayList<Guerrier> guerriers){
        bleu.addAll(guerriers);
    }
    public void ajoutGuerriersRouge(ArrayList<Guerrier> guerriers){
        rouge.addAll(guerriers);
    }

    public boolean haveBlue(){
        return !bleu.isEmpty();
    }
    public boolean haveRed(){
        return !rouge.isEmpty();
    }
}
