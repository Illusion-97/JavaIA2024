package objects.generic;

import serialization.*;

import java.io.IOException;

public class GenericSerializer<T extends Serializer> {
    private final T serializer;

    public GenericSerializer(T serializer) {
        this.serializer = serializer;
    }

    public void serialize() {
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

    public static void main(String[] args) {
        GenericSerializer<TXT> genericTxTSerializer = new GenericSerializer<>(new TXT());
        genericTxTSerializer.serialize();
        GenericSerializer<CSV> genericCsvSerializer = new GenericSerializer<>(new CSV());
        genericCsvSerializer.serialize();
    }
}
