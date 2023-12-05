package objects;

import java.util.ArrayList;
import java.util.List;

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
}
