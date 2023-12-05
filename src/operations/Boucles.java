package operations;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

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

        // Solution foreach
        System.out.print("anIntArray : [");
        int iteration = 0;
        for (int value : anIntArray) { // Syntaxe foreach
            iteration++;
            System.out.print(value + (iteration == anIntArray.length ? "]\n" : ", "));
        }

        // Solution fori
        System.out.print("anIntArray : [");
        for (int i = 0; i < anIntArray.length; i++)
            System.out.print(anIntArray[i] + (i == anIntArray.length - 1 ? "]\n" : ", "));

        // Solution stream
        System.out.printf("anIntArray : [%s]%n",Arrays.stream(anIntArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));

        // Solution sadisme
        System.out.println("anIntArray : " + Arrays.toString(anIntArray));

        boolean[][] aRandomBooleanTable = new boolean[random.nextInt(origin,bound)][random.nextInt(origin,bound)];
        for (int i = 0; i < aRandomBooleanTable.length; i++) {
            for (int j = 0; j < aRandomBooleanTable[i].length; j++) {
                aRandomBooleanTable[i][j] = random.nextBoolean();
            }
        }

        /*
         * [true,false,true]
         * [true,false,true]
         * [true,false,true]
         * [true,false,true]
        * */

        /*
         * [OXO]
         * [OXO]
         * [OXO]
         * [OXO]
         * */

    }
}
