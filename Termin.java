import java.sql.Time;
import java.util.Date;

public class Termin 
{
    Date date;
    String anlassA;
    Time startT;
    Time endT;
    String ortO;
    
    
    
    public Termin(Date d, String anlass, Time start, Time end, String ort) {
        date = d; //evtl. auch date = new Date(int year, int month, int date);
        anlassA = new String(anlass);
        startT = start; //evtl. auch starT = new Time(int hour, int minute, int second);
        endT = end; //evtl. auch endT = new Time(int hour, int minute, int second);
        ortO = new String(ort);
    }

    public void gibdatum()
    {
        startT = new Time(0);
        
    }
    
    public Time gibAnfang()
    {
        return startT;    
    }
    public Time gibEnde()
    {
        return endT;
    }
    public Date gibDatum()
    {
        return date;
    }
    public String gibOrt()
    {
        return ortO;
    }
    public String gibAnlass()
    {
        return anlassA;
    }
    @SuppressWarnings("deprecation")
    public void setzteDatum(int day, int month)
    {
        date.setDate(day);
        date.setMonth(month);
    }
    public void setzteAnlass(String a)
    {
        anlassA = new String(a); 
    }
    @SuppressWarnings("deprecation")
    public void setzteAnfang(int hour, int minute)
    {
        endT.setHours(hour);
        endT.setMinutes(minute);
    }
    @SuppressWarnings("deprecation")
    public void setzteEnde(int hour, int minute)
    {
        startT.setHours(hour);
        startT.setMinutes(minute);
    }
    public void setzeOrt(String o)
    {
        ortO = new String(o);
    }
    public  int istVor(Date d, Time anfang)
    {
        if(date.compareTo(d) == 0) {
            if(startT.compareTo(anfang) == 0)
                return 0;
            if(startT.compareTo(anfang) < 0)
                return -1;
            else
                return 1;
        }
        else 
        {
        if(date.compareTo(d) < 0)
            return -1;
        else
            return 1;
        }
    }
    private int wochenTagBerechnen(int day, int month, int year)   
    {
        int t = day;
        int m = month;
        int j = year;
        int m2, j2=year;
        
        if(m<=2)
            {
            m2=month+10;
            j2=j-1;
                    }
        else
            m2=m-2;
        
        int c = j2/100;
        int y = j2%100;
        
        int h = (((26*m2-2)/10)+t+y+y/4+c/4-2*c)%7;
        
        if(h<0)
            h=h+7;
        return h;

        // Sonntag = 0
        // Montag = 1
        // ...
        // Samstag = 6
    }
    @SuppressWarnings("deprecation")
    public int wochenTagBerechnen()   
    {
        int t = date.getDay();
        int m = date.getMonth();;
        int j = date.getYear();

        System.out.println("t" + t + "m" + m + "j" + j);
        return wochenTagBerechnen(t, m, j);
    }
}
