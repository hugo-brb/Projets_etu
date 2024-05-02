package Personnages;

/**
 * Cette classe représente un Nain, qui est une sous-classe de Guerrier.
 * Les Nains sont des guerriers qui subissent la moitié des dégâts normaux lorsqu'ils sont attaqués.
 */
public class Nain extends Guerrier {

    // Constructeurs

    /**
     * Crée un nouveau Nain avec des paramètres par défaut.
     */
    public Nain() {
        super();
    }

    // Méthodes

    /**
     * Redéfinition de la méthode subirDegats pour permettre au Nain de subir la moitié des dégâts normaux.
     *
     * @param degats les dégâts infligés par l'attaque
     */
    @Override
    public void subirDegats(int degats) {
        super.subirDegats(degats / 2);
    }
}
