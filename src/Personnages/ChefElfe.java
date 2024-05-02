package Personnages;

/**
 * Cette classe représente un Chef Elfe, qui est une sous-classe de Elfe.
 * Les Chefs Elfes sont des Elfes dont la force est doublé par rapport aux Elfes de base.
 */
public class ChefElfe extends Elfe {

    // Constructeurs

    /**
     * Crée un nouveau Chef Elfe avec des paramètres par défaut.
     */
    public ChefElfe() {
        super();
    }

    // Méthodes

    /**
     * Redéfinition de la méthode getForce pour permettre au Chef Elfe d'avoir une force doublé.
     *
     * @return la force doublé du Chef Elfe
     */
    @Override
    public int getForce() {
        return super.getForce() * 2;
    }
}
