import java.sql.Time;
import java.util.Date;
import java.io.Serializable;
import java.util.LinkedList;

public class Kalender implements Serializable {

    private LinkedList<Termin> Liste;

    public Kalender() {
        // initialisieren des Kalenders
        Liste = new LinkedList<Termin>();
    }

    public void addTerminA(Termin t)// alternativ auch mit den einzelnen PArametern, wie Datum, Anlass, Ort, etc.
    {
        int size = Liste.size(); // laenge der Liste
        for (int i = 0; i <= size; i++) // geht die Liste einmal durch
        {
            Termin iterativerTermin = Liste.get(i);
            if (iterativerTermin.istVor(t.gibDatumStart()
            // , t.gibAnfang()
            ) >= 0) {

                Liste.add(i, t); // fügt vor dem nächsten Termin ein, alle weiteren Termine rücken nach hinten
            }

        }

        Liste.addLast(t);// wenn der Termin vor keinem anderen ist wird er ganz hinten eingetragen
    }

    public void addTerminB(Date dS, Date dE, String anlass, String ort, String Kategorie, int tz, String[] teilnehmer)// alternativ auch mit den einzelnen PArametern,
                                                                       // wie Datum, Anlass, Ort, etc.
    {
        Termin t = new Termin(dS, dE, anlass,
                // start,end,
                ort,  Kategorie,  tz,  teilnehmer);
        int size = Liste.size(); // laenge der Liste

        boolean isAdded = false;
        int i = 0;

        System.out.println("addTerminB vor Loop:" + Liste.size());

        while (!isAdded && i < size) {
            Termin iterativerTermin = Liste.get(i);
            if (iterativerTermin.istVor(t.gibDatumStart()
            // ,t.gibAnfang()
            ) >= 0) {
                Liste.add(i, t); // fügt vor dem nächsten Termin ein, alle weiteren Termine rücken nach hinten
                isAdded = true;
            }

            i = i + 1;
        }

        if (!isAdded)
            Liste.addLast(t);// wenn der Termin vor keinem anderen ist wird er ganz hinten eingetragen

        System.out.println("addTerminB ENDE:" + Liste.size());
        System.out.println("Termin wurde hinzugefuegt");
    }

    /*
     * public void addTerminB(Date d, String anlass,Time start,Time end, String
     * ort)//alternativ auch mit den einzelnen PArametern, wie Datum, Anlass, Ort,
     * etc.
     * {
     * Termin t = new Termin( d, anlass, start, end, ort);
     * int size = Liste.size(); //laenge der Liste
     * if (size == 0) {
     * Liste.add(0, t);
     * }
     * else {
     * for(int i = 0; i < size; i++) //geht die Liste einmal durch
     * {
     * Termin iterativerTermin = Liste.get(i);
     * if(iterativerTermin.istVor(t.gibDatum(), t.gibAnfang()) >= 0)
     * {
     * 
     * Liste.add(i, t); //fügt vor dem nächsten Termin ein, alle weiteren Termine
     * rücken nach hinten
     * 
     * 
     * }
     * 
     * 
     * }
     * //}
     * 
     * if
     * Liste.addLast(t);//wenn der Termin vor keinem anderen ist wird er ganz hinten
     * eingetragen
     * System.out.println("addTerminB:" + Liste.size());
     * }
     */
    public boolean removeTerminA(Termin t) // alternativ auch mit den einzelnen Parametern, wie Datum, Anlass, Ort, etc.
    {
        return Liste.remove(t);
        // entfernt termin
    }

    public boolean removeTerminB(Date dS, Date dE, String anlass, Time start, Time end, String ort) // alternativ auch
                                                                                                    // mit den einzelnen
                                                                                                    // PArametern, wie
                                                                                                    // Datum, Anlass,
                                                                                                    // Ort, etc.
    {
        Termin t = new Termin(dS, dE, anlass,
                // start, end,
                ort);
        return Liste.remove(t);
        // entfernt termin
    }

    public int wieVieleTermine() {
        return Liste.size();
        // gibt die Anzahl der Termine aus
    }

    // @SuppressWarnings({ "deprecation"})

    public LinkedList<Termin> gibTermine(Date d) {
        LinkedList<Termin> terminDesTages = new LinkedList<Termin>();
        // Time beginn = new Time(0, 0 , 0);
        // Time schluss = new Time(23, 59 , 59);
        int size = Liste.size();

        // System.out.println("gibTermine zu d:" + d);

        for (int i = 0; i < size; i++) {
            if (Liste.get(i).equalsKalenderTag(d)) {
                System.out.println("Treffer" + Liste.get(i));
                terminDesTages.add(Liste.get(i));
            }
        }

        // return terminDesTages; //entfernt um dead code zu fixen
        return terminDesTages;

    }public LinkedList<Termin> KategorieSortieren(String k)
{
    LinkedList<Termin> Kategorien = new LinkedList<Termin>();
    for (int i = 0; i < Liste.size(); i = i + 1)
    {
        if (k == Liste.get(i).gibKategorie())
        {
            Kategorien.add(Liste.get(i));
        }
    }
    return Kategorien ;
}

}
