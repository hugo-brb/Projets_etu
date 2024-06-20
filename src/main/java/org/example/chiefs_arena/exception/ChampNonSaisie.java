package org.example.chiefs_arena.exception;

/**
 * Exception renvoyée dans le cas où tous les champs obligatoires ne sont pas saisis.
 */

public class ChampNonSaisie extends Exception {
    public ChampNonSaisie(String message) {
        super(message);
    }
}
