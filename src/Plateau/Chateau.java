package Plateau;

import Personnages.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Chateau {

    //attributs
    private final int RESSOURCES_INITIAL = 3;
    private final int AJOUTEE_PAR_TOUR = 1;
    private int ressources;
    private final Couleur c;

    private Plateau pl;

    private ArrayList<Guerrier> lesGuerriersNovice = new ArrayList<>();
    private ArrayList<Guerrier> lesGuerriersEntrainer = new ArrayList<>();

    //Constructors
    public Chateau(Couleur couleur) {
        c=couleur;
        Guerrier g1 = new Guerrier();
        Guerrier g2 = new Guerrier();
        Guerrier g3 = new Guerrier();
        ajoutGuerrierNovice(g1);
        ajoutGuerrierNovice(g2);
        ajoutGuerrierNovice(g3);

    }

    //Méthodes
    public void ajoutPlateau(Plateau pl){this.pl = pl;}
    public void ajoutGuerrierNovice(Guerrier guerrier){
        lesGuerriersNovice.add(guerrier);
    }
    public ArrayList<Guerrier> getGuerriersNovice(){
        return lesGuerriersNovice;
    }

    public void entrainer(){
        if (getRessources() != 0) {
            Scanner lecteur = new Scanner(System.in);
            Iterator<Guerrier> it = getGuerriersNovice().iterator();
            int i = 0;
            Guerrier temp = it.next();
            System.out.println(
                    """
                            |------------------------------------|
                            |              RAPPEL                |
                            |------------------------------------|
                             - Un guerrier novice avec :
                                --> 0 points d'entrainement :
                                        = N'est pas encore prêt au combat
                                --> 1 point d'entrainement :
                                        = Peut devenir un nain
                                --> 2 point d'entrainement :
                                        = Peut devenir un Elfe
                                --> 3 point d'entrainement :
                                        = Peut devenir un Chef Nain
                                --> 4 point d'entrainement :
                                        = Peut devenir un Chef Elfe
                                        
                            A vous de faire les bon choix ;)
                                   
                            """
            );
            while (getRessources() != 0) {
                System.out.println(STR."Le prochain guerrier à entrainer à actuellement \{temp.getNbRessources()} points d'entrainement.");
                System.out.println(STR."Vous avez actuellement \{getRessources()} points d'entrainement disponibles.");
                String choix;
                do {
                    System.out.print("Voulez-vous l'entrainer ? (y|n) ");
                    choix = lecteur.nextLine();
                    if (!choix.equalsIgnoreCase("y") && !choix.equalsIgnoreCase("n")) {
                        System.out.println("Réponse non prise en compte... Veuillez rééssayer !");
                    }
                } while (choix.equalsIgnoreCase("y") && !choix.equalsIgnoreCase("n"));
                if (choix.equalsIgnoreCase("y")) {
                    temp.setNbRessources(1);
                }else{
                    if (temp.getNbRessources() == 4){
                        lesGuerriersEntrainer.add(new ChefElfe());
                        getGuerriersNovice().remove(temp);
                    }
                    if (it.hasNext()) {
                        temp = it.next();
                    }
                }
            }
        }else {
            System.out.println("Pas assez de ressources disponible pour l'entrainement...");
        }
    }

    public void newRecues(){
        Scanner lecteur = new Scanner(System.in);
        ArrayList<Guerrier> tempGuerrier = new ArrayList<>();
        for (Guerrier g : lesGuerriersNovice){
            String temp;
            if (g.getNbRessources()>=1){
                System.out.print(STR."Vous avez un guerrier avec \{g.getNbRessources()}, voulez vous le sortir du chateau ? [y|n] ");
                temp = lecteur.nextLine();
                if (temp.equalsIgnoreCase("y")){
                    if(g.getNbRessources() == 1){
                        lesGuerriersEntrainer.add(new Nain());
                        getGuerriersNovice().remove(g);

                    }else if(g.getNbRessources() == 2){
                        lesGuerriersEntrainer.add(new Elfe());
                        getGuerriersNovice().remove(g);
                    }else if(g.getNbRessources() == 3){
                        lesGuerriersEntrainer.add(new ChefNain());
                        getGuerriersNovice().remove(g);
                    }
                    tempGuerrier.add(lesGuerriersEntrainer.getLast());
                }
            }
        }
        if (estBleu() && !tempGuerrier.isEmpty()){
            pl.getCarreaux().getFirst().ajoutGuerriersBleus(tempGuerrier);
        }else if(!tempGuerrier.isEmpty()){
            pl.getCarreaux().getLast().ajoutGuerriersRouge(tempGuerrier);
        }else {
            System.out.println("Vous n'avez pas de guerrier novices à faire sortir du chateau...");
        }
        incrementerRessources();
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

    public int getRessources() {
        return ressources;
    }

    public ArrayList<Guerrier> getLesGuerriersEntrainer() {
        return lesGuerriersEntrainer;
    }
}
