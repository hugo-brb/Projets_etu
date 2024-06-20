package org.example.chiefs_arena.exception;

/**
 * Exception renvoyée dans le cas où la date est invalide.
 * -La date de début d'un concours est antérieure à celle d'aujourd'hui.
 * -La date de fin de concours est antérieure à celle du début.
 */

public class ConcoursDateInvalide extends Exception {
    public ConcoursDateInvalide(String message) {
        super(message);
    }
}
