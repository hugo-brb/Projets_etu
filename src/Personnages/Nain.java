package Personnages;

public class Nain extends Guerrier {
    //Constructors
    public Nain(){
        super();
    }
    //Méthodes
    public void subirDegats(int degats){
        super.subirDegats(degats/2);
    }
}
