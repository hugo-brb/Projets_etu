package Personnages;
public class ChefElfe extends Elfe {
    //Constructors
    public ChefElfe(){
        super();
    }
    //Méthodes
    public int getforce(){
        return super.getforce()*2;
    }
}
