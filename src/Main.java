import Couleur.Couleur;
import Plateau.Chateau;
import Plateau.Plateau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tour = 1;
        Scanner lecteur = new Scanner(System.in);
        System.out.println(
                """
                        ==========================================================
                        *                                                        *
                        *                      JEU FAERUN                        *
                        *                                                        *
                        ==========================================================
                        """);
        int nbCarreaux;
        do {
            System.out.print("Voulez-vous jouer avec 5, 10 ou 15 carreaux ? ");
            nbCarreaux = lecteur.nextInt(); lecteur.nextLine();
            if (nbCarreaux != 5 && nbCarreaux != 10 && nbCarreaux != 15){
                System.out.println("Merci de choisir un 5, 10 ou 15 carreaux");
            }
        }while (nbCarreaux != 5 && nbCarreaux != 10 && nbCarreaux != 15);

        System.out.println("Création du chateau bleu en cours (Joueur 1) ...");
        Couleur blue = new Couleur("Bleu");
        Chateau bleu = new Chateau(blue);
        System.out.println("Création du chateau bleu fini !");

        System.out.println("Création du chateau rouge en cours (Joueur 2) ...");
        Couleur red = new Couleur("Rouge");
        Chateau rouge = new Chateau(red);
        System.out.println("Création du chateau rouge fini !");

        System.out.println("Création du plateau en cours...");
        Plateau lePlateau = new Plateau(nbCarreaux, bleu, rouge);
        bleu.ajoutPlateau(lePlateau);
        rouge.ajoutPlateau(lePlateau);
        System.out.println("Création du plateau fini !");

        System.out.println("\n\n Bon jeu !\n\n");

        do {
            System.out.println(STR."************************************\n** TOUR \{tour}\n************************************");
            MainUtilitaire.tour(lePlateau, bleu);
            System.out.println("\n\n");
            MainUtilitaire.tour(lePlateau, rouge);
            tour ++;
        }while (!lePlateau.estPartieTerminee());

        System.out.print("""
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                !                                                      !
                !                                                      !
                !                                                      !
                !                                                      !
                !         BRAVO !!!! Nous avons un gagnant !           !
                """);
        System.out.println(
                StringTemplate.STR."!           Le chateau \{lePlateau.getGagnant().getCouleur()} a gagné !                      !"
        );
        System.out.println("""
                !                                                      !
                !                                                      !
                !                                                      !
                !                                                      !
                !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                """);
    }
}