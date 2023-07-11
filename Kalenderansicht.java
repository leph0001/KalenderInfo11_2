import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.NumberFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.text.NumberFormat;

// Alle System.out.println() Methoden werden nur zun Debuggen (Fehlersuchen /-lösen) genutz und sinf für die Funktion des Programms nicht nötig

public class Kalenderansicht implements ActionListener {
    private Kalender kalender; // Backend
    private JFrame Kalenderansicht; // Main Gui
    private int kw; // merkt sich die Karwoche in der sich der Kalender gerade befindet

    // GUI Kalenderansicht
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
    private JLabel hintergrund;
    private ImageIcon iconHintergrund;
    private Image imgHintergrund;
    private Image imageScaleHintergrund;
    private ImageIcon scaleIconHintergrund;

    // GUI Termin hinzufügen
    private JFrame terminHinzufuegenAnsicht;
    private JTextField anlass;
    private JTextField ort;
    private JButton oKButton;
    private JButton abbrechenButton;
    private SpinnerDateModel ds;
    private SpinnerDateModel de;
    private JComboBox<String> Kategorien;
    private JSpinner spinnerstart;
    private JSpinner spinnerend;
    private JButton KategorieHinzufügen;

    // GUI JSpinner
    private Date start;
    private Date end;
    private JSpinner.DateEditor datestart;
    private JSpinner.DateEditor dateend;

    // GUI Ausgabe JSPinner, Kategorie
    private Date startDatumAusgabe;
    private Date endDatumAusgabe;

    // GUI Kategorie hinzufügen
    private JFrame neueKategorie;
    private JTextField NeueKategorie;
    private JButton hinzufügen;
    private JButton abbruchKategorie;

    public Kalenderansicht() {
        kalender = new Kalender(); // Kalender wird initialisiert
        // Variablen initialisieren
        kw = 1;
    }

    public void KalenderansichtStarten() {


        hintergrund = new JLabel("");
		hintergrund.setBounds(0,0,1280,720);
		iconHintergrund = new ImageIcon("Images/Kalender.png");
		imgHintergrund = iconHintergrund.getImage();
		imageScaleHintergrund = imgHintergrund.getScaledInstance(iconHintergrund.getIconWidth()- 340, iconHintergrund.getIconHeight()- 250, Image.SCALE_SMOOTH);
		scaleIconHintergrund = new ImageIcon(imageScaleHintergrund);
		hintergrund.setIcon(scaleIconHintergrund);

        
        // GUI Tagesüberschriften erstellen
        // Montag Überschrift
        JLabel Montag = new JLabel();
        Montag.setText("Montag");
        Montag.setVisible(true);
        Montag.setHorizontalAlignment(SwingConstants.CENTER);
        Montag.setForeground(Color.black);
        Montag.setFont(new Font("Verdana", Font.PLAIN, 20));
        Montag.setOpaque(true);
        Montag.setBounds(150, 200, 150, 40);
        Montag.setVerticalAlignment(JLabel.CENTER);
        Montag.setBackground(Color.GRAY);

        // Dienstag Überschrift
        JLabel Dienstag = new JLabel();
        Dienstag.setText("Dienstag");
        Dienstag.setVisible(true);
        Dienstag.setHorizontalAlignment(SwingConstants.CENTER);
        Dienstag.setForeground(Color.black);
        Dienstag.setFont(new Font("Verdana", Font.PLAIN, 20));
        Dienstag.setOpaque(true);
        Dienstag.setBounds(300, 200, 150, 40);
        Dienstag.setVerticalAlignment(JLabel.CENTER);
        Dienstag.setBackground(Color.GRAY);

        // Mittwoch Überschrift
        JLabel Mittwoch = new JLabel();
        Mittwoch.setText("Mittwoch");
        Mittwoch.setVisible(true);
        Mittwoch.setHorizontalAlignment(SwingConstants.CENTER);
        Mittwoch.setForeground(Color.black);
        Mittwoch.setFont(new Font("Verdana", Font.PLAIN, 20));
        Mittwoch.setOpaque(true);
        Mittwoch.setBounds(450, 200, 150, 40);
        Mittwoch.setVerticalAlignment(JLabel.CENTER);
        Mittwoch.setBackground(Color.GRAY);

        // Donnerstag Überschrift
        JLabel Donnerstag = new JLabel();
        Donnerstag.setText("Donnerstag");
        Donnerstag.setVisible(true);
        Donnerstag.setHorizontalAlignment(SwingConstants.CENTER);
        Donnerstag.setForeground(Color.black);
        Donnerstag.setFont(new Font("Verdana", Font.PLAIN, 20));
        Donnerstag.setOpaque(true);
        Donnerstag.setBounds(600, 200, 150, 40);
        Donnerstag.setVerticalAlignment(JLabel.CENTER);
        Donnerstag.setBackground(Color.GRAY);

        // Freitag Überschrift
        JLabel Freitag = new JLabel();
        Freitag.setText("Freitag");
        Freitag.setVisible(true);
        Freitag.setHorizontalAlignment(SwingConstants.CENTER);
        Freitag.setForeground(Color.black);
        Freitag.setFont(new Font("Verdana", Font.PLAIN, 20));
        Freitag.setOpaque(true);
        Freitag.setBounds(750, 200, 150, 40);
        Freitag.setVerticalAlignment(JLabel.CENTER);
        Freitag.setBackground(Color.GRAY);

        // Samstag Überschrift
        JLabel Samstag = new JLabel();
        Samstag.setText("Samstag");
        Samstag.setVisible(true);
        Samstag.setHorizontalAlignment(SwingConstants.CENTER);
        Samstag.setForeground(Color.black);
        Samstag.setFont(new Font("Verdana", Font.PLAIN, 20));
        Samstag.setOpaque(true);
        Samstag.setBounds(900, 200, 150, 40);
        Samstag.setVerticalAlignment(JLabel.CENTER);
        Samstag.setBackground(Color.GRAY);

        // Sonntag Überschrift
        JLabel Sonntag = new JLabel();
        Sonntag.setText("Sonntag");
        Sonntag.setVisible(true);
        Sonntag.setHorizontalAlignment(SwingConstants.CENTER);
        Sonntag.setForeground(Color.black);
        Sonntag.setFont(new Font("Verdana", Font.PLAIN, 20));
        Sonntag.setOpaque(true);
        Sonntag.setBounds(1050, 200, 150, 40);
        Sonntag.setVerticalAlignment(JLabel.CENTER);
        Sonntag.setBackground(Color.GRAY);

        // GUI Zellen erstellen (Zelle = der Spalte, in der die Termine stehen für den
        // Tag)
        // Montag Zelle
        montagZelle = new JLabel();
        montagZelle.setBounds(150, 240, 150, 455);
        montagZelle.setVerticalAlignment(JLabel.TOP);
        montagZelle.setOpaque(true);

        // Dienstag Zelle
        dienstagZelle = new JLabel();
        dienstagZelle.setBounds(300, 240, 150, 455);
        dienstagZelle.setVerticalAlignment(JLabel.TOP);
        dienstagZelle.setOpaque(true);

        // Mittwoch Zelle
        mittwochZelle = new JLabel();
        mittwochZelle.setBounds(450, 240, 150, 455);
        mittwochZelle.setVerticalAlignment(JLabel.TOP);
        mittwochZelle.setOpaque(true);

        // Donnerstag Zelle
        donnerstagZelle = new JLabel();
        donnerstagZelle.setBounds(600, 240, 150, 455);
        donnerstagZelle.setVerticalAlignment(JLabel.TOP);
        donnerstagZelle.setOpaque(true);

        // Freitag Zelle
        freitagZelle = new JLabel();
        freitagZelle.setBounds(750, 240, 150, 455);
        freitagZelle.setVerticalAlignment(JLabel.TOP);
        freitagZelle.setOpaque(true);

        // Samstag Zelle
        samstagZelle = new JLabel();
        samstagZelle.setBounds(900, 240, 150, 455);
        samstagZelle.setVerticalAlignment(JLabel.TOP);
        samstagZelle.setOpaque(true);

        // Sonntag Zelle
        sonntagZelle = new JLabel();
        sonntagZelle.setBounds(1050, 240, 150, 455);
        sonntagZelle.setVerticalAlignment(JLabel.TOP);
        sonntagZelle.setOpaque(true);

        // Karwochenauswahl erstellen
        // KW Anzeige erstellen
        KWAnzeige = new JLabel();
        KWAnzeige.setText("KW: " + kw);
        KWAnzeige.setVisible(true);
        KWAnzeige.setHorizontalAlignment(JLabel.CENTER);
        KWAnzeige.setForeground(Color.BLACK);
        KWAnzeige.setFont(new Font("Verdana", Font.PLAIN, 25));
        KWAnzeige.setOpaque(false);
        KWAnzeige.setBounds(1050, 100, 100, 50);
        KWAnzeige.setVerticalAlignment(JLabel.CENTER);

        // KWminusButton erstellen
        KWminus = new JButton();
        KWminus.setBounds(10, 200, 150, 300);
        //KWminus.setVisible(true);
        KWminus.addActionListener(this);
        //KWminus.setText("<");
        KWminus.setFocusable(false);
        KWminus.setOpaque(false);
        KWminus.setContentAreaFilled(false);
        KWminus.setBorderPainted(false);
        //KWminus.setBackground(Color.GRAY);

        // KWplusButton erstellen
        KWplus = new JButton();
        KWplus.setBounds(1100, 200, 150, 300);
        //KWplus.setVisible(true);
        KWplus.addActionListener(this);
        //KWplus.setText(">");
        KWplus.setFocusable(false);
        KWplus.setFocusable(false);
        KWplus.setOpaque(false);
        KWplus.setContentAreaFilled(false);
        KWplus.setBorderPainted(false);
        //KWplus.setBackground(Color.GRAY);

        // terminHinzufügen erstellen
        terminHinzufuegen = new JButton();
        terminHinzufuegen.setBounds(500, 110, 250, 50);
        //terminHinzufuegen.setVisible(true);
        terminHinzufuegen.addActionListener(this);
        //terminHinzufuegen.setText("Termin hinzufügen");
        terminHinzufuegen.setFocusable(false);
        //terminHinzufuegen.setBackground(Color.GRAY);
        terminHinzufuegen.setFocusable(false);
        terminHinzufuegen.setOpaque(false);
        terminHinzufuegen.setContentAreaFilled(false);
        terminHinzufuegen.setBorderPainted(false);
        //terminHinzufuegen.setFont(new Font("Verdana", Font.PLAIN, 25));

        // Kalenderansicht (JFrame) initialisieren
        Kalenderansicht = new JFrame();
        Kalenderansicht.setSize(1280, 720);
        Kalenderansicht.setVisible(true);
        Kalenderansicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Kalenderansicht.setResizable(false);
        Kalenderansicht.setTitle("Kalenderansicht");

        //ImageIcon logo = new ImageIcon("logo.png");
        //Kalenderansicht.setIconImage(logo.getImage());
        // Kalenderansicht.getContentPane().setBackground(Color.white);
        //Kalenderansicht.getContentPane().setBackground(new Color(255, 255, 255));
        //Kalenderansicht.setLayout(null);

        // Inhalte Kalenderansicht werden hinzufügen
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
        Kalenderansicht.add(hintergrund, 0);


        Kalenderansicht.add(terminHinzufuegen);
        Kalenderansicht.validate(); // Kalenderansicht wird refreshed -> nur so sind Termine sichtbar
    }

    // Start der Methode
    @SuppressWarnings({ "deprecation" })
    public void KalenderAnsichtInitialisieren2023(int KW) { // füllt die Terminzellen
        for (int i = 0; i < 7; i++) {
            Date d = new Date(2023 - 1900, 0, 2);

            System.out.println("d.toString()" + d.toString());

            long start = d.getTime();
            terminzelleGeben(new Date(start + (KW - 1) * 604800000 + i * 86400000));
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
            Termin t = (Termin) termine.get(i);
            terminzelle = terminzelle + "<html> <BR>" + "<html> <BR>" + t.gibAnlass() + "<html> <BR>"
                    + t.gibAnfangszeit() + " - " + t.gibEndzeit() + "<html> <BR>" + t.gibOrt();
            wochentagZelle(d).setText(terminzelle);

        }

    }

    @SuppressWarnings("deprecation")
    public String wochentagErmitteln(Date d) { // gibt den aktuellen Wochentag als String | aktuell nicht mehr gebraucht
                                               // aber nice to have
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
        } else {
            return ("Sonntag");
        }
    }

    public JLabel wochentagZelle(Date d) { // gibt die Zelle des Wochentags wieder, dessen Datum eingegeben wurde
        @SuppressWarnings({ "deprecation" })
        int i = d.getDay();
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
        } else {
            return sonntagZelle;
        }
    }

    public void terminHinzufuegen() { // öffnet das GUI um einen Termin hinzuzufügen
        // erstellt den JFrame
        terminHinzufuegenAnsicht = new JFrame();
        terminHinzufuegenAnsicht.setSize(1100, 600); // verändert davor (854,480)
        terminHinzufuegenAnsicht.setVisible(true);
        terminHinzufuegenAnsicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        terminHinzufuegenAnsicht.setResizable(false);
        terminHinzufuegenAnsicht.setTitle("Termin hinzufügen");
        terminHinzufuegenAnsicht.setLayout(null);

        // regelt, das nur int in die für Zahlen vorgesehenen Textfelder kommen
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);

        // ab hier werden die einzelnen Textfelder erstellt
        anlass = new JFormattedTextField("Anlass");
        anlass.setBounds(27, 25, 800, 50);
        anlass.setBorder(BorderFactory.createLineBorder(Color.black));

        ort = new JTextField("Ort");
        ort.setBounds(27, 250, 800, 50);
        ort.setBorder(BorderFactory.createLineBorder(Color.black));

        // ab hier die zwei Knöpfe
        oKButton = new JButton("OK");
        oKButton.setBounds(427, 350, 373, 50);
        oKButton.addActionListener(this);
        oKButton.setFocusable(false);
        oKButton.setBackground(Color.GRAY);
        oKButton.setFont(new Font("Verdana", Font.PLAIN, 25));
        oKButton.setVisible(true);

        abbrechenButton = new JButton("Abbrechen"); // macht noch nichts überarbeitet
        abbrechenButton.setBounds(27, 350, 373, 50);
        abbrechenButton.addActionListener(this);
        abbrechenButton.setFocusable(false);
        abbrechenButton.setBackground(Color.GRAY);
        abbrechenButton.setFont(new Font("Verdana", Font.PLAIN, 25));
        abbrechenButton.setVisible(true);

        start = new Date();
        ds = new SpinnerDateModel(start, null, null, Calendar.HOUR_OF_DAY);
        spinnerstart = new JSpinner(ds);
        datestart = new JSpinner.DateEditor(spinnerstart, "HH:mm:ss");
        spinnerstart.setBounds(100, 150, 150, 70);
        // terminHinzufuegenAnsicht.add(spinnerstart);

        end = new Date();
        de = new SpinnerDateModel(end, null, null, Calendar.HOUR_OF_DAY);
        spinnerend = new JSpinner(de);
        dateend = new JSpinner.DateEditor(spinnerend, "HH:mm:ss");
        spinnerend.setBounds(400, 150, 150, 70);
        // terminHinzufuegenAnsicht.add(spinnerend);

        String comboBoxliste[] = { "Hobby", "Arbeit", "Freizeit" };

        Kategorien = new JComboBox<String>(comboBoxliste);
        Kategorien.setBounds(600, 150, 150, 70);
        // terminHinzufuegenAnsicht.add(Kategorien);

        KategorieHinzufügen = new JButton("+");
        KategorieHinzufügen.setBounds(750, 150, 150, 70);
        KategorieHinzufügen.addActionListener(this);
        KategorieHinzufügen.setFocusable(false);
        KategorieHinzufügen.setBackground(Color.GRAY);
        KategorieHinzufügen.setFont(new Font("Verdana", Font.PLAIN, 25));
        KategorieHinzufügen.setVisible(true);

        // terminHinzufuegenAnsicht.add(KategorieHinzufügen);

        // fügt die Komponenten dem JFrame hinzu
        terminHinzufuegenAnsicht.add(anlass, 0);
        terminHinzufuegenAnsicht.add(ort, 0);
        terminHinzufuegenAnsicht.add(oKButton, 0);
        terminHinzufuegenAnsicht.add(abbrechenButton, 0);
        terminHinzufuegenAnsicht.add(spinnerstart, 0);
        terminHinzufuegenAnsicht.add(spinnerend, 0);
        terminHinzufuegenAnsicht.add(Kategorien, 0);
        terminHinzufuegenAnsicht.add(KategorieHinzufügen, 0);

        terminHinzufuegenAnsicht.validate();
    }

    public void zellenLoeschen() { // löscht alle Zellen aus der KW
        montagZelle.setText("");
        dienstagZelle.setText("");
        mittwochZelle.setText("");
        donnerstagZelle.setText("");
        freitagZelle.setText("");
        samstagZelle.setText("");
        sonntagZelle.setText("");
    }

    @SuppressWarnings({ "deprecation" })
    @Override // ab jetzt, was die Knöpfe machen sollen
    public void actionPerformed(ActionEvent e) { // ist der Kopf für alle EventListener (Elemente der Klasse JFrame, die
                                                 // auf eine Aktion warten. Z.B ein Knopf)
        // System.out.println("ACTION:" + e.getSource());
        if (e.getSource() == KWminus) { // wenn der KWminus Button gedrückt wird
            if (kw != 1) {
                System.out.println("e.getSource()  == KWminus");
                kw = kw - 1;
                KWAnzeige.setText("KW: " + kw);
                zellenLoeschen();
                KalenderAnsichtInitialisieren2023(kw);
                Kalenderansicht.validate();
            }
        }
        if (e.getSource() == KWplus) { // wenn der KWplus Button gedrückt wird
            if (kw != 52) {
                kw = kw + 1;
                KWAnzeige.setText("KW: " + kw);
                zellenLoeschen();
                KalenderAnsichtInitialisieren2023(kw);
                Kalenderansicht.validate();
            }
        }
        if (e.getSource() == terminHinzufuegen) { // wenn der terminHinzufuegen Button gedrückt wird
            terminHinzufuegen();
        }

        if (e.getSource() == KategorieHinzufügen) {

            neueKategorie = new JFrame();
            neueKategorie.setSize(400, 300);
            neueKategorie.setTitle("Kategorie hinzufügen");
            neueKategorie.setLayout(null);
            neueKategorie.setLocation(1000, 200);
            neueKategorie.setVisible(true);
            neueKategorie.setResizable(false);

            NeueKategorie = new JFormattedTextField("Neue Kategorie");
            NeueKategorie.setBounds(10, 60, 300, 50);
            neueKategorie.add(NeueKategorie);

            hinzufügen = new JButton("Hinzufügen");
            hinzufügen.setBounds(10, 200, 150, 50);
            hinzufügen.setFocusable(false);
            hinzufügen.setBackground(Color.GRAY);
            hinzufügen.setFont(new Font("Verdana", Font.PLAIN, 25));
            hinzufügen.setVisible(true);
            neueKategorie.add(hinzufügen);

            hinzufügen.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == hinzufügen) {
                        hinzufügenMethode();
                    }
                }

                public void hinzufügenMethode() {

                    if (NeueKategorie.getText().equals("Neue Kategorie"))
                        System.out.println("keine neue Kategorie");
                    else
                        Kategorien.addItem(new String(NeueKategorie.getText()));

                    neueKategorie.dispose();

                }
            });

            JButton abbruchKategorie = new JButton("Abbruch");
            abbruchKategorie.setBounds(220, 200, 150, 50);
            abbruchKategorie.setFocusable(false);
            abbruchKategorie.setBackground(Color.GRAY);
            abbruchKategorie.setFont(new Font("Verdana", Font.PLAIN, 25));
            abbruchKategorie.setVisible(true);
            neueKategorie.add(abbruchKategorie);

            abbruchKategorie.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == abbruchKategorie) {
                        abbruchMethodeKategorie();
                    }
                }

                public void abbruchMethodeKategorie() {
                    neueKategorie.dispose();

                }
            });
        }

        if (e.getSource() == oKButton) { // wenn der okButton gedrückt wird

            startDatumAusgabe = ds.getDate();
            endDatumAusgabe = de.getDate();

            if (startDatumAusgabe.after(endDatumAusgabe))
                System.out.println("error");

            kalender.addTerminB(ds.getDate(), de.getDate(), anlass.getText(), ort.getText());
            System.out.println("nach addTerminB: " + ds.getDate() + de.getDate() + anlass.getText() + ort.getText());

            terminHinzufuegenAnsicht.dispose();
        }

        if (e.getSource() == abbrechenButton) { // wenn der abbrechenButton gedrückt wird

            terminHinzufuegenAnsicht.dispose();
        }

    }
}
