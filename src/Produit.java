public class Produit {
    private String nom;
    private PointC pointC;
    private PointA pointA;
    private Type leType;
    private Classe classe;
    public Produit(String libelle, PointC pointC, PointA pointA, Type leType){
        this.pointA = pointA;
        this.pointC = pointC;
        this.leType = leType;
        this.nom = libelle;
        this.attributUneClasse(this.calculNutriscore());
    }
    public Classe getClasse() {
        return classe;
    }
    private int calculNutriscore(){
        int totalA = this.totalPointAScore(this.pointA), totalC = this.totalPointCScore(this.pointC),
        pointFruitLeg;
        if (this.leType == Type.Boisson){
            pointFruitLeg = CalculUtilitaire.calculFruit_leg_boisson(this.pointC.getFruits_leg());
        }else{
            pointFruitLeg = CalculUtilitaire.calculFruit_leg(this.pointC.getFruits_leg());
        }
        if (totalA >= 11 && !this.nom.equalsIgnoreCase("formage")){
            if (pointFruitLeg == 5){
                return totalA -totalC;
            }else{
                return totalA - pointFruitLeg+CalculUtilitaire.calculFibres(this.pointC.getFibres());
            }
        }else{
            return totalA - totalC;
        }
    }
    private void attributUneClasse(int score){
        if (score <= -1){
            this.classe = Classe.A;
        } else if (score <= 2) {
            this.classe = Classe.B;
        } else if (score <= 10) {
            this.classe = Classe.C;
        } else if (score <= 18) {
            this.classe = Classe.D;
        }else{
            this.classe = Classe.E;
        }
    }
    /**
     * Retourne le total de score pour unPoint donnée en paramètre
     * @return
     */
    private int totalPointAScore(PointA lePoint){
        if (this.leType == Type.Autre){
            return  CalculUtilitaire.calculEnergieAutreMG(lePoint.getEnergie())+
                    CalculUtilitaire.calculSucresSimplesAutresMG(lePoint.getSucreSimples())+
                    CalculUtilitaire.acideGrasSaturesAutresBoisson(lePoint.getAcideGrasSatures())+
                    CalculUtilitaire.sodium(lePoint.getSodium());
        } else if (this.leType == Type.Matiere_grasse) {
            return CalculUtilitaire.calculEnergieAutreMG(lePoint.getEnergie())+CalculUtilitaire.calculSucresSimplesAutresMG(lePoint.getSucreSimples())+
                    CalculUtilitaire.acideGrasSaturesMG(lePoint.getAcideGrasSatures())+CalculUtilitaire.sodium(lePoint.getSodium());
        }else {
            return CalculUtilitaire.calculEnergieBoisson(lePoint.getEnergie())+CalculUtilitaire.calculSucresSimplesBoisson(lePoint.getSucreSimples())+
                    CalculUtilitaire.acideGrasSaturesAutresBoisson(lePoint.getAcideGrasSatures())+CalculUtilitaire.sodium(lePoint.getSodium());
        }
    }
    private int totalPointCScore(PointC lePoint){
        if (this.leType == Type.Autre || this.leType == Type.Matiere_grasse){
            return (CalculUtilitaire.calculFruit_leg(lePoint.getFruits_leg())+
                                CalculUtilitaire.calculFibres(lePoint.getFibres())+CalculUtilitaire.calculProteines(lePoint.getProteines()));
        }else {
            return  (CalculUtilitaire.calculFruit_leg_boisson(lePoint.getFruits_leg())+CalculUtilitaire.calculFibres(lePoint.getFibres())+
                                CalculUtilitaire.calculProteines(lePoint.getProteines()));
        }
    }
    @Override
    public String toString() {
        return "Nom : "+this.nom+", Classe : "+this.classe+"\n" +
                "\t Caractéristiques : \n" +
                "\t Fruits et legumes : "+this.pointC.getFruits_leg()+"\n"+
                "\t Fibres : "+this.pointC.getFibres()+"\n"+
                "\t Protéines : "+this.pointC.getProteines()+"\n"+
                "\t======================================"+"\n"+
                "\t Energie : "+this.pointA.getEnergie()+"\n"+
                "\t SucresSimples : "+this.pointA.getSucreSimples()+"\n"+
                "\t AcidesGrasSaturés : "+this.pointA.getAcideGrasSatures()+"\n"+
                "\t Sodium : "+this.pointA.getSodium();
    }
}
