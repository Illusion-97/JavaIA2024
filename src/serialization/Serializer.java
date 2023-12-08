package serialization;

import java.io.IOException;

public interface Serializer {
    void exportAnnuaire(Annuaire annuaire);

    Annuaire importAnnuaire() throws IOException, ClassNotFoundException;
}
