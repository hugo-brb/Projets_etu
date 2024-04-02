public class PointA {
    private float energie;
    private float sucreSimples;
    private float acideGrasSatures;
    private float sodium;
    public PointA(float energie, float sucreSimples, float acideGrasSatures, float sodium){
        this.energie = energie;
        this.sucreSimples = sucreSimples;
        this.acideGrasSatures = acideGrasSatures;
        this.sodium = sodium;
    }
    public float getAcideGrasSatures() {
        return acideGrasSatures;
    }
    public float getSodium() {
        return sodium;
    }
    public float getSucreSimples() {
        return sucreSimples;
    }
    public float getEnergie() {
        return energie;
    }
}
