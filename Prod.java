public class Prod extends Colab {
    private int qtd;
    private double vlr;

    public Prod(String nm, String mat, int qtd, double vlr) {
        super(nm, mat);
        this.qtd = qtd;
        this.vlr = vlr;
    }

    public double calcPag() {
        return qtd * vlr;
    }

    public String getTp() { return "Produção"; }

    public int getQtd() { return qtd; }
    public double getVlr() { return vlr; }
    public void setQtd(int q) { this.qtd = q; }
    public void setVlr(double v) { this.vlr = v; }
}
