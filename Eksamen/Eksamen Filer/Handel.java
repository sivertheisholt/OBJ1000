package Eksamen;

import java.util.GregorianCalendar;

public class Handel {
    private String selger, kjøper;
    private GregorianCalendar tidspunkt; // dato+klokkeslett for handelen
    private double kurs; // salgskurs, pris pr. verdipapir
    private OmsetteligeVerdipapir omsetteligeVerdipapir; // Referanse til det omsettelige verdipapiret
    private int volum; // antall solgte verdipapirer

    public Handel(String selger, String kjøper, GregorianCalendar tidspunkt, double kurs, int volum,
            OmsetteligeVerdipapir omsetteligeVerdipapir) {
        this.selger = selger;
        this.kjøper = kjøper;
        this.tidspunkt = tidspunkt;
        this.kurs = kurs;
        omsetteligeVerdipapir.setKursverdi(kurs);
        omsetteligeVerdipapir.setAntallHandler(omsetteligeVerdipapir.getAntallHandler() + 1);
        omsetteligeVerdipapir.setTid(tidspunkt);
    }

    public double getTotalBelop() {
        return this.volum * kurs;
    }

    public String getSelger() {
        return selger;
    }

    public String getKjøper() {
        return kjøper;
    }

    public GregorianCalendar getTidspunkt() {
        return tidspunkt;
    }

    public double getKurs() {
        return kurs;
    }

    public int getVolum() {
        return volum;
    }

}
