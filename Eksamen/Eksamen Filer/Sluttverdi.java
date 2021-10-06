package Eksamen;

import java.util.GregorianCalendar;

public class Sluttverdi {
    final public Verdipapir vp;
    final public GregorianCalendar dato;
    final public double sluttkurs;
    final public int antallHandler;

    public Sluttverdi(Verdipapir vp, GregorianCalendar dato, double sluttkurs, int antallHandler) {
        this.vp = vp;
        this.dato = dato;
        this.sluttkurs = sluttkurs;
        this.antallHandler = antallHandler;
    }
}
