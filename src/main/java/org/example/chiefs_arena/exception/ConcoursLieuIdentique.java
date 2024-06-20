package org.example.chiefs_arena.exception;

/**
 * Exception renvoyée dans le cas où un concours crée se déroule dans le même lieu et avant la fin d'un concours précédemment crée.
 */

public class ConcoursLieuIdentique extends Exception {
    public ConcoursLieuIdentique(String message) {
        super(message);
    }
}
