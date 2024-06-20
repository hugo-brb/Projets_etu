package org.example.chiefs_arena.exception;

/***
 * Exception renvoyée dans le cas où un concours crée à le même qu'un concours précédemment crée.
 */

public class ConcoursDejaExistant extends Exception {
    public ConcoursDejaExistant(String message) {
            super(message);
    }

    public ConcoursDejaExistant()
    {
        super("Deux concours ne peuvent pas avoir le même nom");
    }
}

