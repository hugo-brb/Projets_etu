package org.example.chiefs_arena.exception;

/**
 * Exception renvoyée dans le cas où la description dépasse les 1000 caréctères.
 */
public class DescriptionTropLongue extends Exception {
    public DescriptionTropLongue(String message) {
        super(message);
    }
}
