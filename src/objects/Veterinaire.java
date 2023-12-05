package objects;

import java.util.ArrayList;
import java.util.List;

public class Veterinaire {
    public static List<Animal> animaux = new ArrayList<>();

    public static void checkUp() {
        for (Animal animal : animaux) {
            System.out.println(animal.name + " : " + animal.getAgeRange());
        }
    }
}
