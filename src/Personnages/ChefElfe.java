package Personnages;
public class ChefElfe {
    //attributs
    private Elfe e;
    //Constructors
    public ChefElfe(){
        setE();
    }
    //Méthodes

    public Elfe getE() {
        return e;
    }
    public void setE() {
        this.e = new Elfe();
    }
    public int getforce(){
        return this.e.getforce()*2;
    }
}
