package serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TXT {
    private static final String FILENAME = "Annuaire.txt";

    public void exportAnnuaire(Annuaire annuaire) {
        // FileOutputStream -> écriture de String dans un fichier
        // ObjectOutputStream -> utilise un FileOutputStream pour écrire des objets complets
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
            oos.writeObject(annuaire);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Annuaire importAnnuaire() {
        return null;
    }
}
