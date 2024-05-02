package Personnages;

/**
 * Cette classe représente un Elfe, qui est une sous-classe de Guerrier.
 * Les Elfes sont des guerriers dont la force est doublée par rapport aux guerriers de base.
 */
public class Elfe extends Guerrier {

    // Constructeurs

    /**
     * Crée un nouveau Elfe avec des paramètres par défaut.
     */
    public Elfe() {
        super();
    }

    // Méthodes

    /**
     * Renvoie la force de l'Elfe, qui est le double de la force d'un guerrier de base.
     *
     * @return la force de l'Elfe
     */
    @Override
    public int getForce() {
        return super.getForce() * 2;
    }
}