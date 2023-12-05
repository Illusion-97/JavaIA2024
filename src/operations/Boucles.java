package operations;

import java.util.Random;

public class Boucles {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println("Itération : " + i);
        }

        int origin = random.nextInt(1,10),
                bound = origin + random.nextInt(1, origin + 1);

        System.out.printf("Origin : %d, Bound : %d %n",origin,bound);
        for (int i = origin; i <= bound; i++) {
            System.out.println("Itération : " + i);
        }

        // Syntaxe fori : for ({valeur de depart affectée à une variable}; {valeur limite de la variable pour la boucle}; {changement de valeur a chaque itération})
        int[] anIntArray = random.ints(origin, origin, bound).toArray();
        for (int i = 0; i < anIntArray.length; i++) {
            System.out.printf("Index : %d, Value : %d%n",i, anIntArray[i]);
        }

        System.out.print("anIntArray : [");
        for (int value : anIntArray) { // Syntaxe foreach
            System.out.printf("%d, ",value);
        }
        System.out.println("]");
    }
}
