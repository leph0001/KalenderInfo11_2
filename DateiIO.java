import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
 
public class DateiIO {
    public  void speichern(Kalender pKalender) {
        File file = new File("C:\\Users\\Public\\TestFile.ser");
         try {
             FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream stream = new ObjectOutputStream(outputStream);
            stream.writeObject(pKalender);
            stream.close();
        } catch (IOException ioex) {
            System.err.println("Fehler beim Schreiben des Objekts aufgetreten.");
            ioex.printStackTrace();
        }
    }
    public  Kalender laden() {
        Kalender kal = null;
        File file = new File("C:\\Users\\Public\\TestFile.ser");

        try {
            FileInputStream inputstream = new FileInputStream(file);
            ObjectInputStream stream = new ObjectInputStream(inputstream);
            kal = (Kalender) stream.readObject();
            stream.close();
        } catch (ClassNotFoundException cnfex) {
            System.err.println("Die Klasse des geladenen Objekts konnte nicht gefunden werden.");
        } catch (IOException ioex) {
            System.err.println("Das Objekt konnte nicht geladen werden.");
            ioex.printStackTrace();
        }
        return kal;
    }    

}

