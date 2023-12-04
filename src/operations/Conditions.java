package operations;

import java.util.Random;

public class Conditions {
    public static void main(String[] args) {
        Random random = new Random();

        // region Two Cases (true/false)
        int a = random.nextInt(), b = random.nextInt(5), c = random.nextInt(2,5);
        System.out.printf("a = %d; b= %d; c= %d%n",a,b,c);
        // if (condition) {action à exécuter}
        if (a == b) {
            System.out.println("a == b");
        } else if (a == c) {
            System.out.println("a == c");
        } else if (b == c) {
            System.out.println("b == c");
        } else  {
            System.out.println("a != b != c");
        }

        if (a == b && a == c) {
            System.out.println("a == b == c");
        } else {
            if (a == b) {
                System.out.println("a == b");
            } else {
                System.out.println("a != b");
            }
            if (a == c) {
                System.out.println("a == c");
            } else {
                System.out.println("a != c");
            }
            if (b == c) {
                System.out.println("b == c");
            } else {
                System.out.println("b != c");
            }
        }

        if (a == b && a == c) {
            System.out.println("a == b == c");
        } else if (a != b && a != c && b != c) {
            System.out.println("a != b != c");
        } else {
            // Si je ne suis pas dans une égalité complete ou une différence complète
            // C'est qu'il y a forcément une égalité quelque part
            if (a == b) {
                System.out.println("a == b");
            } else if (a == c) {
                System.out.println("a == c");
            } else {
                System.out.println("b == c");
            }
        }

        boolean condition = random.nextBoolean();
        if (condition) {
            System.out.println("Condition Vraie");
        } else {
            System.out.println("Condition Fausse");
        }

        // Syntaxe ternaire : condition ? {valeur si true} : {valeur si false}
        String result = condition ? "vraie" : "fausse";
        System.out.println("Condition " + result);

        System.out.println("Condition " + (condition ? "vraie" : "fausse"));

        System.out.println("Condition " + (random.nextBoolean() ? "vraie" : "fausse"));
        //endregion

        //region Multiple cases
        //endregion
    }
}
