package Personnages;
public class ChefNain {
    //attributs
    private Nain n;
    //Constructors
    public ChefNain(){
        setN();
    }
    //Méthodes

    public Nain getN() {
        return this.n;
    }
    public void setN() {
        this.n = new Nain();
    }
    public void subirDegats(int degats){
        this.n.subirDegats(degats/2);
    }
}
