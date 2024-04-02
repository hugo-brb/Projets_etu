public enum Classe {
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E');
    private char libelle;
    Classe(char libelle){
        this.libelle = libelle;
    }
    @Override
    public String toString() {
        return ""+this.libelle;
    }
}
