package serialization;

import java.io.*;

public class TXT implements Serializer {
    private static final String FILENAME = "Annuaire.txt";

    public static void main(String[] args) {
        TXT serializer = new TXT();
        Annuaire annuaire;
        try {
            annuaire = serializer.importAnnuaire();
        } catch (Exception e) {
            System.out.println("Impossible d'importer l'Annuaire.\nTentative d'export d'un nouvel Annuaire.");
            serializer.exportAnnuaire(Annuaire.createAnnuaire());
            try {
                annuaire = serializer.importAnnuaire();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Impossible d'importer l'Annuaire.\nFin du programme.");
                return;
            }
        }
        System.out.println(annuaire);
    }

    @Override
    public void exportAnnuaire(Annuaire annuaire) {
        // FileOutputStream -> écriture de String dans un fichier
        // ObjectOutputStream -> utilise un FileOutputStream pour écrire des objets complets

        //try with resources : création d'objet qui appelleront automatiquement leur fonction close dans un "finally"
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(annuaire);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Annuaire importAnnuaire() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (Annuaire) ois.readObject();
        }
    }
}
