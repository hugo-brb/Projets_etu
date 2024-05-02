package Personnages;

/**
 * Cette classe représente un Chef Nain, qui est une sous-classe de Nain.
 * Les Chefs Nains sont des Nains qui subissent la moitié des dégâts des nains lorsqu'ils sont attaqués.
 */
public class ChefNain extends Nain {

    // Constructeurs

    /**
     * Crée un nouveau Chef Nain avec des paramètres par défaut.
     */
    public ChefNain() {
        super();
    }

    // Méthodes

    /**
     * Redéfinition de la méthode subirDegats pour permettre au Chef Nain de subir la moitié des dégâts normaux.
     *
     * @param degats les dégâts infligés par l'attaque
     */
    @Override
    public void subirDegats(int degats) {
        super.subirDegats(degats / 2);
    }
}
