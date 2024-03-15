package Couleur;

import java.util.ArrayList;
import java.util.Arrays;

public class Couleur {
    private String couleur;
    public Couleur(String couleur) {
        setCouleur(couleur);
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
//        ArrayList<String> blueChar = new ArrayList<String>(Arrays.asList("blue", "l", "u", "e"));
//        ArrayList<String> redChar = new ArrayList<String>(Arrays.asList("blue", "l", "u", "e"));
//        String[] c = couleur.split("");
//        int b = 0;
//        int r = 0;
        this.couleur = couleur;
    }
}
