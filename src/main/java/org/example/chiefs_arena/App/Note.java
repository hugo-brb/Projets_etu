package org.example.chiefs_arena.App;

import org.example.chiefs_arena.exception.NoteException;

public class Note {
    private int note;

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        try{
            if(note < 0 | note > 10){
                this.note = note;
            }else{
                throw new NoteException("Une note est comprise entre 0 et 10");
            }
        }catch(NoteException e){
            e.getMessage();
        }
    }
}
