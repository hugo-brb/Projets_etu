package Plateau;

import Couleur.Couleur;
import Personnages.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Cette classe représente un château sur le plateau.
 * Un château peut produire des ressources, entraîner des guerriers novices et libérer des guerriers entraînés sur le plateau.
 */
public class Chateau {

    // Attributs
    private final int RESSOURCES_INITIAL = 3;
    private final int AJOUTEE_PAR_TOUR = 1;
    private int ressources;
    private final Couleur c;
    private Plateau pl;
    private ArrayList<Guerrier> lesGuerriersNovice = new ArrayList<>();
    private ArrayList<Guerrier> lesGuerriersEntrainer = new ArrayList<>();

    // Constructeurs
    public Chateau(Couleur couleur) {
        c = couleur;
        Guerrier g1 = new Guerrier();
        Guerrier g2 = new Guerrier();
        Guerrier g3 = new Guerrier();
        ajoutGuerrierNovice(g1);
        ajoutGuerrierNovice(g2);
        ajoutGuerrierNovice(g3);
        ressources = RESSOURCES_INITIAL;
    }

    // Méthodes

    /**
     * Ajoute le plateau auquel appartient ce château.
     *
     * @param pl le plateau auquel ce château appartient
     */
    public void ajoutPlateau(Plateau pl) {
        this.pl = pl;
    }

    /**
     * Ajoute un guerrier novice à ce château.
     *
     * @param guerrier le guerrier novice à ajouter
     */
    public void ajoutGuerrierNovice(Guerrier guerrier) {
        lesGuerriersNovice.add(guerrier);
    }

    /**
     * Renvoie la liste des guerriers novices de ce château.
     *
     * @return la liste des guerriers novices de ce château
     */
    public ArrayList<Guerrier> getGuerriersNovice() {
        return lesGuerriersNovice;
    }

    /**
     * Entraîne les guerriers novices de ce château en fonction des ressources disponibles.
     */
    public void entrainer() {
        if (getRessources() != 0) {
            Scanner lecteur = new Scanner(System.in);
            Iterator<Guerrier> it = getGuerriersNovice().iterator();
            Guerrier temp = it.next();
            System.out.println(
                    """
                            |------------------------------------|
                            |              RAPPEL                |
                            |------------------------------------|
                             - Un guerrier novice avec :
                                --> 0 points d'entraînement :
                                        = N'est pas encore prêt au combat
                                --> 1 point d'entraînement :
                                        = Peut devenir un Nain
                                --> 2 points d'entraînement :
                                        = Peut devenir un Elfe
                                --> 3 points d'entraînement :
                                        = Peut devenir un Chef Nain
                                --> 4 points d'entraînement :
                                        = Peut devenir un Chef Elfe
                                        
                            A vous de faire les bons choix ;)
                            """
            );

            while (getRessources() != 0 && it.hasNext()) {
                System.out.println(STR."Le prochain guerrier à entraîner a actuellement \{temp.getNbRessources()} points d'entraînement.");
                System.out.println(STR."Vous avez actuellement \{getRessources()} points d'entraînement disponibles.");
                String choix;
                do {
                    System.out.print("Voulez-vous l'entraîner ? (y|n) ");
                    choix = lecteur.nextLine();
                    if (!choix.equalsIgnoreCase("y") && !choix.equalsIgnoreCase("n")) {
                        System.out.println("Réponse non prise en compte... Veuillez réessayer !");
                    }
                } while (!choix.equalsIgnoreCase("y") && !choix.equalsIgnoreCase("n"));
                if (choix.equalsIgnoreCase("y")) {
                    temp.setNbRessources(1);
                    this.ressources --;
                } else {
                    if (it.hasNext()) {
                        temp = it.next();
                    }
                }
            }
        } else {
            System.out.println("Pas assez de ressources disponibles pour l'entraînement...");
        }
    }

    /**
     * Libère les guerriers novices de ce château sur le plateau, s'ils ont accumulé suffisamment de ressources.
     */
    public void newRescues() {
        Scanner lecteur = new Scanner(System.in);
        ArrayList<Guerrier> tempGuerrier = new ArrayList<>();
        int i = 0;
        for (Guerrier g : lesGuerriersNovice) {
            String temp;
            if (g.getNbRessources() >= 1) {
                System.out.print(STR."Vous avez un guerrier avec \{g.getNbRessources()} points d'entraînement, voulez-vous le sortir du château ? [y|n] ");
                temp = lecteur.nextLine();
                if (temp.equalsIgnoreCase("y")) {
                    if (g.getNbRessources() == 1) {
                        lesGuerriersEntrainer.add(new Nain());
                        i++;
                    } else if (g.getNbRessources() == 2) {
                        lesGuerriersEntrainer.add(new Elfe());
                        i ++;
                    } else if (g.getNbRessources() == 3) {
                        lesGuerriersEntrainer.add(new ChefNain());
                        i++;
                    }else if (g.getNbRessources() == 4) {
                        lesGuerriersEntrainer.add(new ChefElfe());
                        i++;
                    }
                    tempGuerrier.add(lesGuerriersEntrainer.getLast());
                    if (estBleu() && !tempGuerrier.isEmpty()) {
                        pl.getCarreaux().getFirst().ajoutGuerriersBleus(tempGuerrier);
                    } else if (!tempGuerrier.isEmpty()) {
                        pl.getCarreaux().getLast().ajoutGuerriersRouge(tempGuerrier);
                    }
                }
            }
        }
        for (int j = 0; j < i; j++){
            lesGuerriersNovice.remove(lesGuerriersNovice.getLast());
        }
         if (tempGuerrier.isEmpty()){
            System.out.println("Vous n'avez pas de guerrier novice à faire sortir du château...");
        }
        incrementerRessources();
        ajoutGuerrierNovice(new Guerrier());
    }

    /**
     * Incrémente le nombre de ressources disponibles.
     */
    private void incrementerRessources() {
        this.ressources += AJOUTEE_PAR_TOUR;
    }

    /**
     * Renvoie la couleur de ce château.
     *
     * @return la couleur de ce château
     */
    public Couleur getCouleur() {
        return this.c;
    }

    /**
     * Vérifie si ce château est de couleur bleue.
     *
     * @return true si ce château est de couleur bleue, sinon false
     */
    public boolean estBleu() {
        return c.getCouleur().equalsIgnoreCase("bleu");
    }

    /**
     * Vérifie si ce château est de couleur rouge.
     *
     * @return true si ce château est de couleur rouge, sinon false
     */
    public boolean estRouge() {
        return c.getCouleur().equalsIgnoreCase("rouge");
    }

    /**
     * Renvoie le nombre de ressources disponibles pour l'entraînement.
     *
     * @return le nombre de ressources disponibles pour l'entraînement
     */
    public int getRessources() {
        return ressources;
    }

    /**
     * Renvoie la liste des guerriers entraînés de ce château.
     *
     * @return la liste des guerriers entraînés de ce château
     */
    public ArrayList<Guerrier> getLesGuerriersEntrainer() {
        return lesGuerriersEntrainer;
    }
}
