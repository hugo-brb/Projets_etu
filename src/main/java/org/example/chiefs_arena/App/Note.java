package org.example.chiefs_arena.App;

import org.example.chiefs_arena.exception.NoteException;

import java.util.InputMismatchException;

/**
 * Représente une note donnée par un membre du jury d'un concours.
 * Une note est une valeur entière comprise entre 0 et 10 inclus.
 */

public class Note {
    private int note;

    /**
     * Obtient le nom de la catégorie.
     * @return Le nom de la catégorie.
     */
    public int getNote() {
        return note;
    }

    /**
     * Définit la note attribuée par un membre du Jury.
     * Si l'utilisateur saisit une note inférieure à 0 ou superieure à 10 alors la saisie est refusée avec un
     * message d'erreur indiquant que la note doit être comprise entre 0 et 10.
     * @param note la note donné par un membre du Jury sur le plat d'un participant
     * @throws NoteException Exception
     */

    public void setNote(int note) throws NoteException {
        try{
            if (note < 0 || note > 10) {
                throw new NoteException("Une note doit être comprise entre 0 et 10");
            }
            this.note = note;
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }
}

