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
        System.out.println("\u001B[36mFightClub.startTournament\u001B[0m");
        chiens.stream().forEach(chien -> chien.bark());
    }

    public static void inscrire(Chien chien){
        chiens.add(chien);
    }
}
