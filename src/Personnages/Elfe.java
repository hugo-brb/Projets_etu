package Personnages;

public class Elfe extends Guerrier {
    //Constructors
    public Elfe(){
        super();
    }
    //Méthodes
    public int getforce(){
        return super.getForce()*2;
    }
}
