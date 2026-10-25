public class Comm extends Colab {
    private double vend;
    private double perc;

    public Comm(String nm, String mat, double vend, double perc) {
        super(nm, mat);
        this.vend = vend;
        this.perc = perc;
    }

    public double calcPag() {
        return vend * (perc / 100.0);
    }

    public String getTp() { return "Comm"; }

    public double getVend() { return vend; }
    public double getPerc() { return perc; }
    public void setVend(double v) { this.vend = v; }
    public void setPerc(double p) { this.perc = p; }
}
