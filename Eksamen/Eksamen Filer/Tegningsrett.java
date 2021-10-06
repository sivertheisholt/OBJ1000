package Eksamen;

import java.util.GregorianCalendar;

public class Tegningsrett extends OmsetteligeVerdipapir {
    private String tegningsdato;
    private double tegningskursen;
    private Aksje aksje;

    public Tegningsrett(String isin, String Ticker, String navn, GregorianCalendar tidspunkt, double kursverdi,
            int antallHandler, String tegningsdato, double tegningskursen, Aksje aksje) {
        super(isin, Ticker, navn, tidspunkt, kursverdi, antallHandler);
        this.tegningsdato = tegningsdato;
        this.tegningskursen = tegningskursen;
        this.aksje = aksje;
    }

    public String getTegningsdato() {
        return this.tegningsdato;
    }

    public void setTegningsdato(String tegningsdato) {
        this.tegningsdato = tegningsdato;
    }

    public double getTegningskursen() {
        return this.tegningskursen;
    }

    public void setTegningskursen(double tegningskursen) {
        this.tegningskursen = tegningskursen;
    }

    public Aksje getAksje() {
        return this.aksje;
    }

    public void setAksje(Aksje aksje) {
        this.aksje = aksje;
    }

    @Override
    public void dagSlutt() {
        Sluttverdi sluttverdi = new Sluttverdi(this, tidspunkt, kursverdi, antallHandler);
        sluttverdier.add(sluttverdi);
    }

    @Override
    public void nullstill() {
        setKursverdi(0);
        setAntallHandler(0);
        setTid(null);
    }
}
