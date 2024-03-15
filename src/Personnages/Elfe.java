package Personnages;

public class Elfe {
    //attributs
    private Guerrier g;
    //Constructors
    public Elfe(){
        setG();
    }
    //Méthodes

    public Guerrier getG() {
        return g;
    }
    public void setG() {
        this.g = new Guerrier();
    }
    public int getforce(){
        return this.g.getForce()*2;
    }
}
