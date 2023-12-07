import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Objet pouvant récupérer une saisie dans la console
        //String line = scanner.nextLine();
        //int saisie = scanner.nextInt();
        /*boolean invalid = true;
        do {
            try {
                System.out.println("Saisissez un entier : ");
                Scanner scanner = new Scanner(System.in);
                int saisie = scanner.nextInt();
                invalid = false;
                System.out.println(saisie);
            } catch (Exception e) {
                System.out.println("Saisie invalide.");
            }
        } while (invalid);*/
        System.out.println("Saisissez un entier : ");
        System.out.println(getInputInt());
    }

    private static int getInputInt() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Saisie invalide.");
            return getInputInt();
        }
    }
}