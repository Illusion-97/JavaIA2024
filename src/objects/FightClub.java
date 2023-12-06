package objects;

import java.util.ArrayList;
import java.util.List;

public class FightClub {
    private static List<Chien> chiens = new ArrayList<>();

    public static void annonce() {
        for (Chien chien : chiens) {
            System.out.println("Combattant : " + (chiens.indexOf(chien) + 1));
            chien.bark();
        }
    }

    public static void startTournament() {

    }

    public static void inscrire(Chien chien){
        chiens.add(chien);
    }
}
