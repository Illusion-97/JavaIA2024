package serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TXT {
    private static final String FILENAME = "Annuaire.txt";

    public static void main(String[] args) {
        TXT serializer = new TXT();
        serializer.exportAnnuaire(Annuaire.createAnnuaire());
    }

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
