package org.example.chiefs_arena.exception;

/**
 * Exception renvoyée dans le cas où la note n'est pas comprise entre 0 et 10 inclus.
 */
public class NoteException extends Exception{
    public NoteException(String message){
        super(message);
    }
}
