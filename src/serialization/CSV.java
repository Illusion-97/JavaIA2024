package serialization;

import java.io.*;

public class CSV {
    private static final String FILENAME = "Annuaire.csv";

    public static void main(String[] args) {
        CSV serializer = new CSV();
        Annuaire annuaire;
        serializer.exportAnnuaire(Annuaire.createAnnuaire());
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

    public void exportAnnuaire(Annuaire annuaire) {
        try (FileWriter fw = new FileWriter(FILENAME)) {
            fw.append(annuaire.getNom());
            fw.append(",");
            fw.append(annuaire.getOwner().getNom());
            fw.append(";");
            fw.append(String.valueOf(annuaire.getOwner().getTel()));
            fw.append("\n");
            annuaire.getContacts().forEach(person -> {

            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Annuaire importAnnuaire() throws IOException, ClassNotFoundException {
        return null;
    }
}
