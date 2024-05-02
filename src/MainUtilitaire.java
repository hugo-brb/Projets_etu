import Plateau.Chateau;
import Plateau.Plateau;

public class MainUtilitaire {
    public static void tour(Plateau pl, Chateau cha ){
        System.out.println(STR." --> Joueur \{cha.getCouleur()} à vous de jouer !");
        System.out.println(STR.
                """
                        Vous avez actuellement :
                        - \{cha.getGuerriersNovice().size()} guerriers en cours de formation
                        - \{cha.getLesGuerriersEntrainer().size()} guerriers sur le champs de bataille

                        Entrainez vos troupes :
                        """
        );
        cha.entrainer();
        System.out.println("Déplacement des guerriers en cours...");
        pl.deplaceGuerriers(cha.getCouleur());
        cha.newRecues();
    }
}
