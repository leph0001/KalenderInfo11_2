
//import java.sql.Time;
import java.sql.Time;
import java.util.Date;

public class Termin {
    Date dateStart;
    Date dateEnd;
    String anlassA;
    Time startT;
    Time endT;
    String ortO;
    boolean ganztaegig;
    String Kategorie1;
    int teilnehmerAnzahl;
    String[] teilnehmer;

    public Termin(Date dstart, Date dend, String anlass,
            // Time start, Time end,
            String ort, String Kategorie, int tz, String[] teilnehmer) {
        dateStart = dstart; // evtl. auch date = new Date(int year, int month, int date);
        dateEnd = dend;
        anlassA = new String(anlass);
        // startT = start; //evtl. auch starT = new Time(int hour, int minute, int
        // second);
        // endT = end; //evtl. auch endT = new Time(int hour, int minute, int second);
        ortO = new String(ort);
        Kategorie1= Kategorie;
        teilnehmer = new String[tz];
        if (dstart.equals(dend)) {
            ganztaegig = false;
        }
    }

    public boolean istganztaegig() {
        return ganztaegig;
    }

    @SuppressWarnings("deprecation")
    public String gibAnfangszeit() {
        return dateStart.getHours() + ":" + dateStart.getMinutes();
        // return startT.getHours() + " - " + endT.getMinutes();
    }

    @SuppressWarnings("deprecation")
    public String gibEndzeit() {
        return dateEnd.getHours() + ":" + dateEnd.getMinutes();
    }

    public Date gibDatumStart() {
        return dateStart;
    }

    public Date gibDatumEnd() {
        return dateEnd;
    }

    public String gibOrt() {
        return ortO;
    }

    public String gibAnlass() {
        return anlassA;
    }

    @SuppressWarnings("deprecation")
    public void setzeDatumEnd(int day, int month) {
        dateEnd.setDate(day);
        dateEnd.setMonth(month);
    }

    @SuppressWarnings("deprecation")
    public void setzeDatumStart(int day, int month) {
        dateStart.setDate(day);
        dateStart.setMonth(month);
    }

    @SuppressWarnings("deprecation")
    public void setzeDatum(int dayS, int monthS, int dayE, int monthE) {
        dateStart.setDate(dayS);
        dateStart.setMonth(monthS);
        dateEnd.setDate(dayE);
        dateEnd.setMonth(monthE);
    }

    public void setzteAnlass(String a) {
        anlassA = new String(a);
    }

    // @SuppressWarnings("deprecation")
    // public void setzteAnfang(int hour, int minute)
    // {
    // endT.setHours(hour);
    // endT.setMinutes(minute);
    // }
    // @SuppressWarnings("deprecation")
    // public void setzteEnde(int hour, int minute)
    // {
    // startT.setHours(hour);
    // startT.setMinutes(minute);
    // }
    public void setzeOrt(String o) {
        ortO = new String(o);
    }

    public int istVor(Date d
    // ,Time anfang
    ) {
        if (dateStart.compareTo(d) == 0) {
            // if(startT.compareTo(anfang) == 0)
            return 0;
            // if(startT.compareTo(anfang) < 0)
            // return -1;
            // else
            // return 1;
        } else {
            if (dateStart.compareTo(d) < 0)
                return -1;
            else
                return 1;
        }
    }

    public boolean zwischen(Date d)
    {
        return d.after(this.dateStart) && d.before(this.dateEnd);
    }
    public String gibKategorie()
    {
        return Kategorie1;
    }

public void setzeKategorie(String K)
    {
        Kategorie1 = new String(K);
    }

    @SuppressWarnings("deprecation")
    public boolean equalsKalenderTag(Date d)
    {   
        Date s = new Date(this.dateStart.getYear(), this.dateStart.getMonth(), this.dateStart.getDate(), 0, 0);
        Date e = new Date(this.dateEnd.getYear(), this.dateEnd.getMonth(), this.dateEnd.getDate(), 23, 59);

        /*
        System.out.println("d:" + d);
        System.out.println("s:" + s);
        System.out.println("e:" + e);
        */
        return d.equals(s) || d.equals(e) || (d.after(s) && d.before(e));
    }

    private int wochenTagBerechnen(int day, int month, int year) {
        int t = day;
        int m = month;
        int j = year;
        int m2, j2 = year;

        if (m <= 2) {
            m2 = month + 10;
            j2 = j - 1;
        } else
            m2 = m - 2;

        int c = j2 / 100;
        int y = j2 % 100;

        int h = (((26 * m2 - 2) / 10) + t + y + y / 4 + c / 4 - 2 * c) % 7;

        if (h < 0)
            h = h + 7;
        return h;

        // Sonntag = 0
        // Montag = 1
        // ...
        // Samstag = 6
    }

    @SuppressWarnings("deprecation")
    public int wochenTagBerechnen() {
        int t = dateStart.getDay();
        int m = dateStart.getMonth();
        ;
        int j = dateStart.getYear();

        System.out.println("t" + t + "m" + m + "j" + j);
        return wochenTagBerechnen(t, m, j);
    }
}
