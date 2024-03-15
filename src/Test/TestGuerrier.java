package Test;

import Personnages.Guerrier;

public class TestGuerrier {
    public static void main(String[] args) {
        Guerrier g1 = new Guerrier();
        Guerrier g2 = new Guerrier();

        g1.attaquer(g2);
        System.out.println("Point de vie restant à g2 après une attaque de g1 : \n"+
                g2.getPointsDeVie());

        System.out.println("ATTAQUE DE g2 sur g1 : \n"+
                "--------------------------------------------");
        int i = 1;
        while (g1.estVivant() && g2.estVivant()){
            if (i%2==0){
                g1.attaquer(g2);
            }else {
                g2.attaquer(g1);
            }
            System.out.println("Tour n°"+i+" :\n"+
                    "G1 : "+g1.getPointsDeVie() + " points de vie\n"
                    + "G2 : "+ g2.getPointsDeVie() + " points de vie");
            i++;
        }
        if (!g1.estVivant()){
            System.out.println("g1 est mort en premier");
        }else {
            System.out.println("g2 est mort en premier");
        }
    }
}
