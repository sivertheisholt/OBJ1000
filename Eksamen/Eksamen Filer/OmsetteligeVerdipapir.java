package Eksamen;

import java.util.GregorianCalendar;

public abstract class OmsetteligeVerdipapir extends Verdipapir {
    protected GregorianCalendar tidspunkt;
    protected double kursverdi;
    protected int antallHandler;

    public OmsetteligeVerdipapir(String isin, String Ticker, String navn, GregorianCalendar tidspunkt, double kursverdi,
            int antallHandler) {
        super(isin, Ticker, navn);
        if (kursverdi < 0 || antallHandler < 0) {
            return;
        }
        this.tidspunkt = tidspunkt;
        this.kursverdi = kursverdi;
        this.antallHandler = antallHandler;
    }

    public GregorianCalendar getTid() {
        return this.tidspunkt;
    }

    public void setTid(GregorianCalendar tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public double getKursverdi() {
        return this.kursverdi;
    }

    public void setKursverdi(double kursverdi) {
        this.kursverdi = kursverdi;
    }

    public int getAntallHandler() {
        return this.antallHandler;
    }

    public void setAntallHandler(int antallHandler) {
        this.antallHandler = antallHandler;
    }

    public abstract void nullstill();
}
