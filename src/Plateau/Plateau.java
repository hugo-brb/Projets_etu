package Plateau;

import Couleur.Couleur;
import java.util.ArrayList;

/**
 * Cette classe représente le plateau de jeu.
 * Le plateau est composé de plusieurs carreaux et châteaux.
 */
public class Plateau {

    // Attributs
    ArrayList<Carreau> lesCarreaux = new ArrayList<>();
    ArrayList<Chateau> lesChateaux = new ArrayList<>();
    Couleur gagnant;

    // Constructeurs
    public Plateau(int longeur, Chateau bleu, Chateau rouge){
        for (int i=0 ; i<longeur; i++ ){
            lesCarreaux.add(new Carreau());
        }
        lesChateaux.add(bleu);
        lesChateaux.add(rouge);
    }

    // Méthodes

    /**
     * Déplace les guerriers d'une couleur donnée sur le plateau.
     *
     * @param c la couleur des guerriers à déplacer
     */
    public void deplaceGuerriers(Couleur c){
        if (c.getCouleur().equalsIgnoreCase("bleu")){
            for (int i=0; i<lesCarreaux.size()-2; i++){
                if (lesCarreaux.get(i).haveBlue()) {
                    lesCarreaux.get(i + 1).ajoutGuerriersBleus(lesCarreaux.get(i).getGuerriersBleus());
                    lesCarreaux.get(i).getGuerriersBleus().clear();
                    if (lesCarreaux.get(i + 1).haveRed()) {
                        lanceCombat(c, lesCarreaux.get(i + 1));
                    }
                }
            }
        }else {
            for (int i=lesCarreaux.size()-1; i>0; i--){
                if (lesCarreaux.get(i).haveRed()) {
                    lesCarreaux.get(i - 1).ajoutGuerriersRouge(lesCarreaux.get(i).getGuerriersRouges());
                    lesCarreaux.get(i).getGuerriersRouges().clear();
                    if (lesCarreaux.get(i - 1).haveBlue()) {
                        lanceCombat(c, lesCarreaux.get(i - 1));
                    }
                }
            }
        }
    }

    /**
     * Lance un combat sur le plateau.
     */
    public void lanceCombat(Couleur c, Carreau ca){
        int temp;
        if (c.getCouleur().equalsIgnoreCase("bleu")){
            temp = 0;
        }else{
            temp = 1;
        }

        while(ca.haveRed() && ca.haveBlue()){
            if (temp == 0){
                ca.getGuerriersBleus().getFirst().attaquer(ca.getGuerriersRouges().getFirst());
                if (ca.getGuerriersBleus().getFirst().getPointsDeVie() <= 0){
                    ca.getGuerriersBleus().remove(ca.getGuerriersBleus().getFirst());
                }else if (ca.getGuerriersRouges().getFirst().getPointsDeVie() <= 0){
                    ca.getGuerriersRouges().remove(ca.getGuerriersRouges().getFirst());
                }
                temp = 1;
            }else {
                ca.getGuerriersRouges().getFirst().attaquer(ca.getGuerriersBleus().getFirst());
                if (ca.getGuerriersRouges().getFirst().getPointsDeVie() <= 0){
                    ca.getGuerriersRouges().remove(ca.getGuerriersRouges().getFirst());
                }else if (ca.getGuerriersBleus().getFirst().getPointsDeVie() <= 0) {
                    ca.getGuerriersBleus().remove(ca.getGuerriersBleus().getFirst());
                }
                temp = 0;
            }
        }
    }

    /**
     * Vérifie si la partie est terminée en vérifiant si un des châteaux est vide.
     *
     * @return true si la partie est terminée, sinon false
     */
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

    /**
     * Renvoie la couleur du gagnant de la partie.
     *
     * @return la couleur du gagnant de la partie
     */
    public Couleur getGagnant(){
        return gagnant;
    }

    /**
     * Renvoie la liste des carreaux sur le plateau.
     *
     * @return la liste des carreaux sur le plateau
     */
    public ArrayList<Carreau> getCarreaux(){
        return lesCarreaux;
    }

    /**
     * Renvoie le carreau de départ pour les guerriers bleus.
     *
     * @return le carreau de départ pour les guerriers bleus
     */
    public Carreau getDepartBleu(){
        return lesCarreaux.getFirst();
    }

    /**
     * Renvoie le carreau de départ pour les guerriers rouges.
     *
     * @return le carreau de départ pour les guerriers rouges
     */
    public Carreau getDepartRouge(){
        return lesCarreaux.getLast();
    }

}
