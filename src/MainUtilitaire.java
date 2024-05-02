import Plateau.Chateau;
import Plateau.Plateau;

/**
 * Cette classe contient des utilitaires pour le déroulement d'un tour de jeu.
 */
public class MainUtilitaire {

    /**
     * Effectue un tour de jeu pour un château donné sur un plateau donné.
     *
     * @param pl le plateau de jeu
     * @param cha le château du joueur
     */
    public static void tour(Plateau pl, Chateau cha ){
        System.out.println(" --> Joueur " + cha.getCouleur() + ", à vous de jouer !");
        System.out.println(
                """
                Vous avez actuellement :
                - """ + cha.getGuerriersNovice().size() + " guerriers en cours de formation\n" +
                        "                - " + cha.getLesGuerriersEntrainer().size() + " guerriers sur le champ de bataille\n" +
                        "\n" +
                        "                Entraînez vos troupes :"
        );
        cha.entrainer();
        System.out.println("Déplacement des guerriers en cours...");
        pl.deplaceGuerriers(cha.getCouleur());
        cha.newRescues();
    }
}
