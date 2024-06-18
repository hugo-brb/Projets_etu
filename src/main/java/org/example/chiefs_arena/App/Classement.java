package org.example.chiefs_arena.App;

import java.util.List;

public class Classement {
    private int position;
    private List<Participant> podium;

    public Classement(){

    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Participant> getPodium() {
        return podium;
    }

    public void setPodium(List<Participant> podium) {
        this.podium = podium;
    }
}
