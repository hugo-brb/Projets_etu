package Personnages;
public class ChefNain extends Nain {

    //Constructors
    public ChefNain(){
        super();
    }
    //Méthodes

    public void subirDegats(int degats){
        super.subirDegats(degats/2);
    }
}
