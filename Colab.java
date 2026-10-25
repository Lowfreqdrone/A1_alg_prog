public class Colab {
    protected String nm;
    protected String mat;

    public Colab(String nm, String mat) {
        this.nm = nm;
        this.mat = mat;
    }

    public String getNm() { return nm; }
    public String getMat() { return mat; }

    public void setNm(String nm) { this.nm = nm; }

    public double calcPag() {
        return 0.0;
    }

    public String getTp() { return "Padrão"; }

    public String toString() {
        return String.format("[%s] Matrícula: %s | Nome: %s | Pagamento: R$ %.2f",
                getTp(), mat, nm, calcPag());
    }
}
