package Couleur;

/**
 * Cette classe représente une couleur.
 * Elle permet de stocker et de récupérer une couleur.
 */
public class Couleur {
    private String couleur;

    /**
     * Crée une nouvelle instance de Couleur avec la couleur spécifiée.
     *
     * @param couleur la couleur à attribuer
     */
    public Couleur(String couleur) {
        setCouleur(couleur);
    }

    /**
     * Renvoie la couleur actuellement définie.
     *
     * @return la couleur actuellement définie
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Définit une nouvelle couleur.
     *
     * @param couleur la nouvelle couleur à définir
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
