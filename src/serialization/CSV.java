package serialization;

import java.io.*;

public class CSV {
    private static final String FILENAME = "Annuaire.csv";
    private static final String DELIMITER = ",";
    public static final String PERSON_DELIMITER = ";";
    public static final String LINE_BREAK = "\n";

    public static void main(String[] args) {
        CSV serializer = new CSV();
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

    public void exportAnnuaire(Annuaire annuaire) {
        try (FileWriter fw = new FileWriter(FILENAME)) {
            fw.append(annuaire.getNom());
            fw.append(DELIMITER);
            appendPerson(annuaire.getOwner(),fw);
            annuaire.getContacts().forEach(person -> {
                // Les exceptions possibles dans une lambda doivent être gérées à l'intérieur de celle-ci
                try {
                    appendPerson(person, fw);
                } catch (IOException e) {
                    System.out.println("Impossible d'insérer le contact : " + person);
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void appendPerson(Person person, FileWriter fw) throws IOException {
        fw.append(person.getNom());
        fw.append(PERSON_DELIMITER);
        fw.append(String.valueOf(person.getTel()));
        fw.append(LINE_BREAK);
    }

    public Annuaire importAnnuaire() throws IOException, ClassNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            // Chaque appel à la fonction readLine passe à la ligne suivante
            String line = br.readLine();
        }
        return new Annuaire("",null,null);
    }
}
