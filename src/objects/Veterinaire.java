package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Veterinaire {
    private static List<Animal> animaux = new ArrayList<>();

    public static void checkUp() {
        for (Animal animal : animaux) {
            System.out.println(animal.name + " : " + animal.getAgeRange());
            if(animal instanceof BergerAllemand) ((BergerAllemand) animal).displayPride();
        }
    }

    public static void declarer(Animal animal){
        animaux.add(animal);
    }

    public static void bilan() {
        System.out.println("\u001B[36mVeterinaire.bilan\u001B[0m");
        animaux.stream()
                .filter(animal -> animal.getAgeRange() == Animal.AgeRange.SENIOR)
                .map(animal -> animal.name)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
