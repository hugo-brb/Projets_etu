package Plateau;

import Personnages.Guerrier;
import java.util.ArrayList;

/**
 * Cette classe représente un carreau sur le plateau.
 * Un carreau peut contenir des guerriers affiliés à la couleur bleue ou rouge.
 */
public class Carreau {
    private ArrayList<Guerrier> bleu = new ArrayList<>();
    private ArrayList<Guerrier> rouge = new ArrayList<>();

    /**
     * Crée un nouveau carreau.
     */
    public Carreau(){

    }

    /**
     * Renvoie la liste des guerriers affiliés à la couleur bleue sur ce carreau.
     *
     * @return la liste des guerriers affiliés à la couleur bleue sur ce carreau
     */
    public ArrayList<Guerrier> getGuerriersBleus(){
        return bleu;
    }

    /**
     * Renvoie la liste des guerriers affiliés à la couleur rouge sur ce carreau.
     *
     * @return la liste des guerriers affiliés à la couleur rouge sur ce carreau
     */
    public ArrayList<Guerrier> getGuerriersRouges(){
        return rouge;
    }

    /**
     * Ajoute une liste de guerriers affiliés à la couleur bleue sur ce carreau.
     *
     * @param guerriers la liste de guerriers affiliés à la couleur bleue à ajouter
     */
    public void ajoutGuerriersBleus(ArrayList<Guerrier> guerriers){
        bleu.addAll(guerriers);
    }

    /**
     * Ajoute une liste de guerriers affiliés à la couleur rouge sur ce carreau.
     *
     * @param guerriers la liste de guerriers affiliés à la couleur rouge à ajouter
     */
    public void ajoutGuerriersRouge(ArrayList<Guerrier> guerriers){
        rouge.addAll(guerriers);
    }

    /**
     * Vérifie si ce carreau contient des guerriers affiliés à la couleur bleue.
     *
     * @return true si ce carreau contient des guerriers affiliés à la couleur bleue, false sinon
     */
    public boolean haveBlue(){
        return !bleu.isEmpty();
    }

    /**
     * Vérifie si ce carreau contient des guerriers affiliés à la couleur rouge.
     *
     * @return true si ce carreau contient des guerriers affiliés à la couleur rouge, false sinon
     */
    public boolean haveRed(){
        return !rouge.isEmpty();
    }
}
