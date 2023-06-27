import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants; 

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import java.util.Date;
import java.util.LinkedList;
import java.sql.Time;
import java.text.NumberFormat;

// Alle System.out.println() Methoden werden nur zun Debuggen (Fehlersuchen /-lösen) genutz und sinf für die Funktion des Programms nicht nötig

public class Kalenderansicht implements ActionListener{
    private Kalender kalender; //Backend
    private JFrame Kalenderansicht; //Main Gui
    private int kw; //merkt sich die Karwoche in der sich der Kalender gerade befindet


    //GUI Kalenderansicht
    private JButton KWminus; 
    private JButton KWplus;
    private JLabel KWAnzeige;
    private JLabel montagZelle;
    private JLabel dienstagZelle;
    private JLabel mittwochZelle;
    private JLabel donnerstagZelle;
    private JLabel freitagZelle;
    private JLabel samstagZelle;
    private JLabel sonntagZelle;
    private JButton terminHinzufuegen;

    //GUI Termin hinzufügen
    private JFrame terminHinzufuegenAnsicht;
    private JTextField anlass;
    private JFormattedTextField startH; //Startsunde vom neuen Termin
    private JFormattedTextField startM; //Startminute vom neuen Termin
    private JFormattedTextField endH;   //Endstunde vom neuen Termin
    private JFormattedTextField endM;   //Endminute vom neuen Termin
    private JFormattedTextField dateY;  //Datum Jahr vom neuen Termin
    private JFormattedTextField dateM;  //Datum Monat vom neuen Termin
    private JFormattedTextField dateD;  //Datum Tag vom neuen Termin
    private JTextField ort;
    private JButton oKButton;
    private JButton abbrechenButton;



    public Kalenderansicht(){
        kalender = new Kalender(); //Kalender wird initialisiert
        //Variablen initialisieren
        kw = 1;
    }

    public void KalenderansichtStarten() {
        
        

        //GUI Tagesüberschriften erstellen
        //Montag Überschrift
        JLabel Montag = new JLabel();
        Montag.setText("Montag");
        Montag.setVisible(true);
        Montag.setHorizontalAlignment(SwingConstants.CENTER);
        Montag.setForeground(Color.black);
        Montag.setFont(new Font("Verdana", Font.PLAIN,20));
        Montag.setOpaque(true);
        Montag.setBounds(150, 200, 150, 40);
        Montag.setVerticalAlignment(JLabel.CENTER); 
        Montag.setBackground(Color.GRAY);
        

        //Dienstag Überschrift
        JLabel Dienstag = new JLabel();
        Dienstag.setText("Dienstag");
        Dienstag.setVisible(true);
        Dienstag.setHorizontalAlignment(SwingConstants.CENTER);
        Dienstag.setForeground(Color.black);
        Dienstag.setFont(new Font("Verdana", Font.PLAIN,20));
        Dienstag.setOpaque(true);
        Dienstag.setBounds(300, 200, 150, 40);
        Dienstag.setVerticalAlignment(JLabel.CENTER); 
        Dienstag.setBackground(Color.GRAY);

        //Mittwoch Überschrift
        JLabel Mittwoch = new JLabel();
        Mittwoch.setText("Mittwoch");
        Mittwoch.setVisible(true);
        Mittwoch.setHorizontalAlignment(SwingConstants.CENTER);
        Mittwoch.setForeground(Color.black);
        Mittwoch.setFont(new Font("Verdana", Font.PLAIN,20));
        Mittwoch.setOpaque(true);
        Mittwoch.setBounds(450, 200, 150, 40);
        Mittwoch.setVerticalAlignment(JLabel.CENTER);
        Mittwoch.setBackground(Color.GRAY);

        //Donnerstag Überschrift
        JLabel Donnerstag = new JLabel();
        Donnerstag.setText("Donnerstag");
        Donnerstag.setVisible(true);
        Donnerstag.setHorizontalAlignment(SwingConstants.CENTER);
        Donnerstag.setForeground(Color.black);
        Donnerstag.setFont(new Font("Verdana", Font.PLAIN,20));
        Donnerstag.setOpaque(true);
        Donnerstag.setBounds(600, 200, 150, 40);
        Donnerstag.setVerticalAlignment(JLabel.CENTER); 
        Donnerstag.setBackground(Color.GRAY);

        //Freitag Überschrift
        JLabel Freitag = new JLabel();
        Freitag.setText("Freitag");
        Freitag.setVisible(true);
        Freitag.setHorizontalAlignment(SwingConstants.CENTER);
        Freitag.setForeground(Color.black);
        Freitag.setFont(new Font("Verdana", Font.PLAIN,20));
        Freitag.setOpaque(true);
        Freitag.setBounds(750, 200, 150, 40);
        Freitag.setVerticalAlignment(JLabel.CENTER); 
        Freitag.setBackground(Color.GRAY);

        //Samstag Überschrift
        JLabel Samstag = new JLabel();
        Samstag.setText("Samstag");
        Samstag.setVisible(true);
        Samstag.setHorizontalAlignment(SwingConstants.CENTER);
        Samstag.setForeground(Color.black);
        Samstag.setFont(new Font("Verdana", Font.PLAIN,20));
        Samstag.setOpaque(true);
        Samstag.setBounds(900, 200, 150, 40);
        Samstag.setVerticalAlignment(JLabel.CENTER); 
        Samstag.setBackground(Color.GRAY);

        //Sonntag Überschrift
        JLabel Sonntag = new JLabel();
        Sonntag.setText("Sonntag");
        Sonntag.setVisible(true);
        Sonntag.setHorizontalAlignment(SwingConstants.CENTER);
        Sonntag.setForeground(Color.black);
        Sonntag.setFont(new Font("Verdana", Font.PLAIN,20));
        Sonntag.setOpaque(true);
        Sonntag.setBounds(1050, 200, 150, 40);
        Sonntag.setVerticalAlignment(JLabel.CENTER); 
        Sonntag.setBackground(Color.GRAY);
        
        //GUI Zellen erstellen (Zelle = der Spalte, in der die Termine stehen für den Tag)
        //Montag Zelle
        montagZelle = new JLabel();
        montagZelle.setBounds(150, 240, 150, 455);
        montagZelle.setVerticalAlignment(JLabel.TOP);
        montagZelle.setOpaque(true);
       
        //Dienstag Zelle
        dienstagZelle = new JLabel();
        dienstagZelle.setBounds(300, 240, 150, 455);
        dienstagZelle.setVerticalAlignment(JLabel.TOP);
        dienstagZelle.setOpaque(true);
        
        //Mittwoch Zelle
        mittwochZelle = new JLabel();
        mittwochZelle.setBounds(450, 240, 150, 455);
        mittwochZelle.setVerticalAlignment(JLabel.TOP);
        mittwochZelle.setOpaque(true);

        //Donnerstag Zelle
        donnerstagZelle = new JLabel();
        donnerstagZelle.setBounds(600, 240, 150, 455);
        donnerstagZelle.setVerticalAlignment(JLabel.TOP);
        donnerstagZelle.setOpaque(true);
        
        //Freitag Zelle
        freitagZelle = new JLabel();
        freitagZelle.setBounds(750, 240, 150, 455);
        freitagZelle.setVerticalAlignment(JLabel.TOP);
        freitagZelle.setOpaque(true);

        //Samstag Zelle
        samstagZelle = new JLabel();
        samstagZelle.setBounds(900, 240, 150, 455);
        samstagZelle.setVerticalAlignment(JLabel.TOP);
        samstagZelle.setOpaque(true);

        //Sonntag Zelle
        sonntagZelle = new JLabel();
        sonntagZelle.setBounds(1050, 240, 150, 455);
        sonntagZelle.setVerticalAlignment(JLabel.TOP);
        sonntagZelle.setOpaque(true);



        //Karwochenauswahl erstellen
        //KW Anzeige erstellen
        KWAnzeige = new JLabel();
        KWAnzeige.setText("KW: " + kw);
        KWAnzeige.setVisible(true);
        KWAnzeige.setHorizontalAlignment(JLabel.CENTER);
        KWAnzeige.setForeground(Color.BLACK);
        KWAnzeige.setFont(new Font("Verdana", Font.PLAIN,25));
        KWAnzeige.setOpaque(false);
        KWAnzeige.setBounds(1050, 100, 100, 50);
        KWAnzeige.setVerticalAlignment(JLabel.CENTER); 
        
        
        // KWminusButton erstellen 
        KWminus = new JButton();
        KWminus.setBounds(1000, 100, 50, 50);
        KWminus.setVisible(true);
        KWminus.addActionListener(this);
        KWminus.setText("<");
        KWminus.setFocusable(false);
        KWminus.setOpaque(true);
        KWminus.setBackground(Color.GRAY);

        // KWplusButton erstellen 
        KWplus = new JButton();
        KWplus.setBounds(1150, 100, 50, 50);
        KWplus.setVisible(true);
        KWplus.addActionListener(this);
        KWplus.setText(">");
        KWplus.setFocusable(false);
        KWplus.setBackground(Color.GRAY);


        // terminHinzufügen erstellen
        terminHinzufuegen = new JButton();
        terminHinzufuegen.setBounds(150, 100, 300, 50);
        terminHinzufuegen.setVisible(true);
        terminHinzufuegen.addActionListener(this);
        terminHinzufuegen.setText("Termin hinzufügen");
        terminHinzufuegen.setFocusable(false);
        terminHinzufuegen.setBackground(Color.GRAY);
        terminHinzufuegen.setFont(new Font("Verdana", Font.PLAIN,25));


        // Kalenderansicht (JFrame) initialisieren
        Kalenderansicht = new JFrame();
        Kalenderansicht.setSize(1920, 1080);
        Kalenderansicht.setVisible(true);
        Kalenderansicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Kalenderansicht.setResizable(false);
        Kalenderansicht.setTitle("Kalenderansicht");

        ImageIcon logo = new ImageIcon("logo.png");
        Kalenderansicht.setIconImage(logo.getImage());
        //Kalenderansicht.getContentPane().setBackground(Color.white);
        Kalenderansicht.getContentPane().setBackground(new Color(255,255,255));
        Kalenderansicht.setLayout(null);

        
        //Inhalte Kalenderansicht werden hinzufügen
        Kalenderansicht.add(Montag, 0);
        Kalenderansicht.add(Dienstag, 0);
        Kalenderansicht.add(Mittwoch, 0); 
        Kalenderansicht.add(Donnerstag, 0);
        Kalenderansicht.add(Freitag, 0);
        Kalenderansicht.add(Samstag, 0);
        Kalenderansicht.add(Sonntag, 0);

        Kalenderansicht.add(montagZelle, 0);
        Kalenderansicht.add(dienstagZelle, 0);
        Kalenderansicht.add(mittwochZelle, 0); 
        Kalenderansicht.add(donnerstagZelle, 0);
        Kalenderansicht.add(freitagZelle, 0);
        Kalenderansicht.add(samstagZelle, 0);
        Kalenderansicht.add(sonntagZelle, 0);

        Kalenderansicht.add(KWAnzeige, 0);
        Kalenderansicht.add(KWminus, 0);
        Kalenderansicht.add(KWplus, 0);

        Kalenderansicht.add(terminHinzufuegen);
        Kalenderansicht.validate(); // Kalenderansicht wird refreshed -> nur so sind Termine sichtbar
    }
    
    
    //Start der Methode
    @SuppressWarnings({ "deprecation"}) 
    public void KalenderAnsichtInitialisieren2023(int KW) { //füllt die Terminzellen
        for (int i = 0; i < 7;i++) {
            Date d = new Date(2023-1900, 0, 2);

            //System.out.println( "d.toString()" + d.toString() );

            long start = d.getTime();
            terminzelleGeben(new Date(start + (KW-1)*604800000 +i*86400000)); //funktioniert nur für 2023
        }
    }

    public void terminzelleGeben(Date d) { // Ergänzungsfunktion zu KalenderAnsichtInitialisieren2023(int KW)
        LinkedList<Termin> termine = new LinkedList<Termin>();
        System.out.println("terminzelleGeben vor gibtTermine" + d.toString());
        termine = kalender.gibTermine(d);
        System.out.println("terminzelleGeben nach" + termine);
        System.out.println("termine.size():" + termine.size());
        String terminzelle = "";
        for (int i = 0; i < termine.size(); i++) {
            Termin t = (Termin)termine.get(i);
            terminzelle = terminzelle + "<html> <BR>" + "<html> <BR>" + t.gibAnlass() + "<html> <BR>" + t.gibAnfang() + " - " + t.gibEnde() + "<html> <BR>"  + t.gibOrt();
            wochentagZelle(d).setText(terminzelle);

        } 

            
    }


    @SuppressWarnings("deprecation")   
    public String wochentagErmitteln(Date d) { //gibt den aktuellen Wochentag als String | aktuell nicht mehr gebraucht aber nice to have
        int i = d.getDay();
        if (i == 1) {
            return ("Montag");
        }
        if (i == 2) {
            return ("Dienstag");
        }
        if (i == 3) {
            return ("Mittwoch");
        }
        if (i == 4) {
            return ("Donnerstag");
        }
        if (i == 5) {
            return ("Freitag");
        }
        if (i == 6) {
            return ("Samstag");
        }
        else {
            return ("Sonntag");
        }
    }


    public JLabel wochentagZelle(Date d) { //gibt die Zelle des Wochentags wieder, dessen Datum eingegeben wurde
        @SuppressWarnings({ "deprecation"}) int i = d.getDay();
        if (i == 1) {
            return montagZelle;
        }
        if (i == 2) {
            return dienstagZelle;
        }
        if (i == 3) {
            return mittwochZelle;
        }
        if (i == 4) {
            return donnerstagZelle;
        }
        if (i == 5) {
            return freitagZelle;
        }
        if (i == 6) {
            return samstagZelle;
        }
        else {
            return sonntagZelle;
        }
    }


    public void terminHinzufuegen() { //öffnet das GUI um einen Termin hinzuzufügen
        // erstellt den JFrame
        terminHinzufuegenAnsicht = new JFrame();
        terminHinzufuegenAnsicht.setSize(854, 480);
        terminHinzufuegenAnsicht.setVisible(true);
        terminHinzufuegenAnsicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        terminHinzufuegenAnsicht.setResizable(false);
        terminHinzufuegenAnsicht.setTitle("Termin hinzufügen");
        terminHinzufuegenAnsicht.setLayout(null);

        //regelt, das nur int in die für Zahlen vorgesehenen Textfelder kommen
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);

        // ab hier werden die einzelnen Textfelder erstellt
        anlass = new JFormattedTextField("Anlass");
        anlass.setBounds(27, 25, 800, 50);
        anlass.setBorder(BorderFactory.createLineBorder(Color.black));

        startH = new JFormattedTextField(format);
        startH.setBounds(27, 100, 181, 50);
        startH.setText("Startstunde");
        startH.setBorder(BorderFactory.createLineBorder(Color.black));
        startH.setVisible(true);

        startM = new JFormattedTextField(format);
        startM.setBounds(219, 100, 181, 50);
        startM.setText("Startminute");
        startM.setBorder(BorderFactory.createLineBorder(Color.black));
        startM.setVisible(true);

        endH = new JFormattedTextField(format);
        endH.setBounds(427, 100, 181, 50);
        endH.setText("Endzeit");
        endH.setBorder(BorderFactory.createLineBorder(Color.black));

        endM = new JFormattedTextField(format);
        endM.setBounds(619, 100, 181, 50);
        endM.setText("Endzeit");
        endH.setBorder(BorderFactory.createLineBorder(Color.black));

        dateY = new JFormattedTextField(format);
        dateY.setBounds(27, 175, 260, 50);
        dateY.setText("Jahr");
        dateY.setBorder(BorderFactory.createLineBorder(Color.black));

        dateM = new JFormattedTextField(format);
        dateM.setBounds(297, 175, 260, 50);
        dateM.setText("Monat");
        dateM.setBorder(BorderFactory.createLineBorder(Color.black));

        dateD = new JFormattedTextField(format);
        dateD.setBounds(567, 175, 260, 50);
        dateD.setText("Tag");
        dateD.setBorder(BorderFactory.createLineBorder(Color.black));

        ort = new JTextField("Ort");
        ort.setBounds(27, 250, 800, 50);
        ort.setBorder(BorderFactory.createLineBorder(Color.black));

        //ab hier die zwei Knöpfe 
        oKButton = new JButton("OK");
        oKButton.setBounds(427, 350, 373, 50);
        oKButton.addActionListener(this);

        abbrechenButton = new JButton("Abbrechen"); //macht noch nichts
        abbrechenButton.setBounds(27, 350, 373, 50);
        abbrechenButton.addActionListener(this);

        //fügt die Komponenten dem JFrame hinzu
        terminHinzufuegenAnsicht.add(anlass, 0);
        terminHinzufuegenAnsicht.add(ort, 0);
        terminHinzufuegenAnsicht.add(oKButton, 0);
        terminHinzufuegenAnsicht.add(abbrechenButton, 0);
        terminHinzufuegenAnsicht.add(startH, 0);
        terminHinzufuegenAnsicht.add(startM, 0);
        terminHinzufuegenAnsicht.add(endH, 0);
        terminHinzufuegenAnsicht.add(endM, 0);
        terminHinzufuegenAnsicht.add(dateY, 0);
        terminHinzufuegenAnsicht.add(dateM, 0);
        terminHinzufuegenAnsicht.add(dateD, 0);
        terminHinzufuegenAnsicht.validate();
    }


    public void zellenLoeschen() { //löscht alle Zellen aus der KW
        montagZelle.setText("");
        dienstagZelle.setText("");
        mittwochZelle.setText("");
        donnerstagZelle.setText("");
        freitagZelle.setText("");
        samstagZelle.setText("");
        sonntagZelle.setText("");
    }

    @SuppressWarnings({ "deprecation"}) 
    @Override //ab jetzt, was die Knöpfe machen sollen
    public void actionPerformed(ActionEvent e) { //ist der Kopf für alle EventListener (Elemente der Klasse JFrame, die auf eine Aktion warten. Z.B ein Knopf)
        // System.out.println("ACTION:" + e.getSource());
        if (e.getSource() == KWminus) { //wenn der KWminus Button gedrückt wird
            if (kw != 1){
                System.out.println("e.getSource()  == KWminus");
                kw = kw - 1;
                KWAnzeige.setText("KW: " + kw); 
                zellenLoeschen();
                KalenderAnsichtInitialisieren2023(kw);
                Kalenderansicht.validate();
            }
        }
        if (e.getSource() == KWplus) { //wenn der KWplus Button gedrückt wird
            if (kw != 52){
                kw = kw + 1;
                KWAnzeige.setText("KW: " + kw);
                zellenLoeschen();
                KalenderAnsichtInitialisieren2023(kw);
                Kalenderansicht.validate();
            }
        }
        if (e.getSource() == terminHinzufuegen) { //wenn der terminHinzufuegen Button gedrückt wird
            terminHinzufuegen();
        }

        if (e.getSource() == oKButton) { //wenn der okButton gedrückt wird
            String tAnlass = anlass.getText();
            
            //initialisieren der lokalen Variabeln
            int sH = 0; //Startstunde
            int sM = 0; //Startminute
            int eH = 0; //Endstunde
            int eM = 0; //Endminute
            int dY = 0; //Datum Jahr
            int dM = 0; //Datum Monat
            int dD = 0; //Datum Tag

            //Umwandeln der in int benötigten Textfelder von String zu int
            try{
                sH = Integer.parseInt(startH.getText());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            try{
                sM = Integer.parseInt(startM.getText());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            try{
                eH = Integer.parseInt(endH.getText());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            try{
                eM = Integer.parseInt(endM.getText());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            

            System.out.println(dY + dM + dD);
            try{
                dY = Integer.parseInt(dateY.getText());
                System.out.println(dY);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            try{
                dM = Integer.parseInt(dateM.getText());
                System.out.println(dM);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            try{
                dD = Integer.parseInt(dateD.getText());
                System.out.println(dD);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }

            
            Time tAnfang = new Time(sH, sM, 0);
            Time tEnde = new Time(eH, eM, 0);
            System.out.println(tAnfang.toString());
            Date tDatum = new Date(dY-1900, dM - 1, dD);
            System.out.println(tDatum.toString());
            String tOrt = ort.getText();
            System.out.println(tOrt);

            kalender.addTerminB(tDatum, tAnlass, tAnfang, tEnde, tOrt);
            System.out.println("nach addtermin");
            
        }
        if (e.getSource() == abbrechenButton) { //wenn der abbrechenButton gedrückt wird
            
        }
    }
}
 
