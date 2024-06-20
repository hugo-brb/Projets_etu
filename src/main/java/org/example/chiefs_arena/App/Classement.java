package org.example.chiefs_arena.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente le classement des participants dans un concours.
 */
public class Classement {
    private int position;
    private List<Participant> podium = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    public Classement() {}

    /**
     * Constructeur de la classe Classement.
     * @param position Le position d'un partcipant dans le classement.
     * @param podium Le podium du classement.
     */

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
     * Définit la liste de tous les participants du classement d'un concours
     * @return la liste de tous les participants à classer
     */
    public List<Participant> getParticipants(){
        return participants;
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
     * Méthode permettant de calculer la moyenne des 3 notes obtenues par un participant. Il y a 3 jurés dans un concours.
     * @param notes
     * @return la moyenne de 3 notes
     */

    public int moyenne(List<Note> notes){
        int somme = 0;
        for (int i=0; i < notes.size(); i++){
            somme+=notes.get(i).getNote();
        }
        return somme/3;
    }

    /**
     * Génére le classement des participants à un concours en fonction de la moyenne de leurs notes données par les 3 jurés.
     * @param participants
     */

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
