package Eksamen;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Aksjefond extends Verdipapir {
    private String forvalter;
    private ArrayList<Aksje> aksjer;

    public Aksjefond(String isin, String Ticker, String navn, String forvalter) {
        super(isin, Ticker, navn);
        this.forvalter = forvalter;
    }

    public String getForvalter() {
        return this.forvalter;
    }

    public void setForvalter(String forvalter) {
        this.forvalter = forvalter;
    }

    public ArrayList<Aksje> getAksjer() {
        return this.aksjer;
    }

    public void setAksjer(ArrayList<Aksje> aksjer) {
        this.aksjer = aksjer;
    }

    public void leggTilAksje(Aksje aksje) {
        int id = aksjer.indexOf(aksje);
        if (id == -1) {
            aksjer.add(aksje);
        }
    }

    public void fjernAksje(Aksje aksje) {
        int id = aksjer.indexOf(aksje);
        if (id != -1) {
            aksjer.remove(id);
        }
    }

    public int antallAksjer() {
        Map<String, String> antallAksjerSelskap = new HashMap<String, String>();
        for (Aksje aksje : aksjer) {
            if (!antallAksjerSelskap.containsKey(aksje.navn)) {
                antallAksjerSelskap.put(aksje.navn, "Selskap");
            }
        }
        return antallAksjerSelskap.size();
    }

    @Override
    public void dagSlutt() {
        double kursverdi = 0;
        for (Aksje aksje : aksjer) {
            kursverdi += aksje.kursverdi;
        }
        kursverdi = kursverdi / aksjer.size();
        GregorianCalendar calendar = new GregorianCalendar();
        Sluttverdi sluttverdi = new Sluttverdi(this, calendar, kursverdi, 0);
        sluttverdier.add(sluttverdi);
    }
}
