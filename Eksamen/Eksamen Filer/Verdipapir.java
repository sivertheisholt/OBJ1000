package Eksamen;

import java.util.ArrayList;

public abstract class Verdipapir implements Comparable<Verdipapir> {
    protected final String isin;
    protected String ticker;
    protected String navn;
    protected static ArrayList<Sluttverdi> sluttverdier;

    public Verdipapir(String isin, String ticker, String navn) {
        this.isin = isin;
        this.ticker = ticker;
        this.navn = navn;
    }

    public String getIsin() {
        return this.isin;
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String Ticker) {
        this.ticker = Ticker;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String toString() {
        return getTicker() + " " + getNavn();
    }

    public boolean equals(Verdipapir verdipapir) {
        return this.getIsin() == verdipapir.isin;
    }

    public abstract void dagSlutt();

    public double[] getSluttKurser() {
        double[] sluttkurser = new double[this.sluttverdier.size()];
        for (int i = 0; i < this.sluttverdier.size(); i++) {
            sluttkurser[i] = this.sluttverdier.get(i).sluttkurs;
        }
        return sluttkurser;
    }

    public int compareTo(Verdipapir verdipapir) {
        return this.getNavn().compareTo(verdipapir.getNavn());
    }
}
