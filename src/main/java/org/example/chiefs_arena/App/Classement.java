package org.example.chiefs_arena.App;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Représente le classement des participants dans un concours.
 */
public class Classement {
    private int position;
    private List<Participant> podium = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    public Classement() {}

    public Classement(int position, List<Participant> podium) {
        this.position = position;
        this.podium = podium;
    }

    /**
     * Obtient la position du classement.
     * @return La position du classement.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Définit la position du classement.
     * @param position La nouvelle position du classement.
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Obtient la liste des participants sur le podium.
     * @return La liste des participants sur le podium.
     */
    public List<Participant> getPodium() {
        for(int i=0; i < 3; i++){
            podium.add(participants.get(i));
        }
        return podium;
    }

    /**
     * Définit la liste des participants sur le podium.
     * @param podium La nouvelle liste des participants sur le podium.
     */
    public void setPodium(List<Participant> podium) {
        this.podium = podium;
    }

    public List<Participant> getParticipants(){
        return participants;
    }
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public int moyenne(List<Note> notes){
        int somme = 0;
        for (int i=0; i < notes.size(); i++){
            somme+=notes.get(i).getNote();
        }
        return somme/3;
    }

    public void genererClassement(List<Participant> participants){
        int j;
        int i = 0;
        boolean permute = true;

        while(permute){
            while(i < participants.size()) {
                j = participants.size() - 1;
                permute = false;
                while(j > i){
                    if(moyenne(participants.get(j-1).getNotesJury()) > moyenne(participants.get(j).getNotesJury())){
                        Participant temporaire = participants.get(j);
                        participants.set(j,participants.get(j-1));
                        participants.set(j-1, temporaire);
                        permute = true;
                    }
                    j--;
                }
                i++;
            }
        }
    }
}
