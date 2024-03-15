package Personnages;

public class Nain {
    //attributs
    private Guerrier g;
    //Constructors
    public Nain(){
        setG();
    }
    //Méthodes

    public Guerrier getG() {
        return g;
    }
    public void setG() {
        this.g = new Guerrier();
    }
    public void subirDegats(int degats){
        this.g.subirDegats(degats/2);
    }
}
