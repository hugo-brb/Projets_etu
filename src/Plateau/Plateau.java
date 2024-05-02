package Plateau;

import Couleur.Couleur;
import java.util.ArrayList;

public class Plateau {
    //Attributs
    ArrayList<Carreau> lesCarreaux = new ArrayList<>();
    ArrayList<Chateau> lesChateaux = new ArrayList<>();
    Couleur gagnant;

    //Constructors
    public Plateau(int longeur, Chateau bleu, Chateau rouge){
        for (int i=0 ; i<longeur; i++ ){
            lesCarreaux.add(new Carreau());
        }
        lesChateaux.add(bleu);
        lesChateaux.add(rouge);
    }

    //Méthodes

    public void deplaceGuerriers(Couleur c){
        if (c.getCouleur().equalsIgnoreCase("bleu")){
            for (int i=0; i<lesCarreaux.size()-2; i++){
                lesCarreaux.get(i+1).ajoutGuerriersBleus(lesCarreaux.get(i).getGuerriersBleus());
                lesCarreaux.get(i).getGuerriersBleus().clear();


            }
        }else {
            for (int i=lesCarreaux.size()-1; i>0; i--){
                lesCarreaux.get(i-1).ajoutGuerriersRouge(lesCarreaux.get(i).getGuerriersRouges());
                lesCarreaux.get(i).getGuerriersRouges().clear();
            }
        }
    }

    public void lanceCombat(){

    }

    public boolean estPartieTerminee(){
        if (lesCarreaux.getFirst().haveRed()){
            gagnant = lesChateaux.getLast().getCouleur();
            return true;
        } else if (lesCarreaux.getLast().haveBlue()) {
            gagnant = lesChateaux.getFirst().getCouleur();
            return true;
        }else {
            return false;
        }
    }

    public Couleur getGagnant(){
        return gagnant;
    }

    public ArrayList<Carreau> getCarreaux(){
        return lesCarreaux;
    }

    public Carreau getDepartBleu(){
        return lesCarreaux.getFirst();
    }

    public Carreau getDepartRouge(){
        return lesCarreaux.getLast();
    }

}
