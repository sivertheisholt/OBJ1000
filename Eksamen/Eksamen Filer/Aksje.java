package Eksamen;

import java.util.GregorianCalendar;

public class Aksje extends OmsetteligeVerdipapir {
    enum Sektor {
        TELEKOM, MINERAL, LANDBRUK, SKOGBRUK, FANGST, FISKE, HELSE, BUTIKK, BYGG, UNDERVISNING, DATA
    }

    private double palydende;
    private Sektor sektor;

    public Aksje(String isin, String Ticker, String navn, GregorianCalendar tidspunkt, double kursverdi,
            int antallHandler, double palydende, Sektor sektor) {
        super(isin, Ticker, navn, tidspunkt, kursverdi, antallHandler);
        this.palydende = palydende;
        this.sektor = sektor;
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
