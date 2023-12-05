package objects;

public class Jardin {
    public static void main(String[] args) {
        Animal anAnimal = new Animal();
        System.out.println("anAnimal.id = " + anAnimal.id);
        Animal anotherAnimal = new Animal();
        System.out.println("anotherAnimal.id = " + anotherAnimal.id);
        Animal namedAnimal = new Animal("Petiot");
        System.out.println("namedAnimal.id = " + namedAnimal.id);
        System.out.println("namedAnimal.name = " + namedAnimal.name);
        Animal animalErrant = new Animal("Errant", 3, null, null);
        Animal pedigree = new Animal("Pedigree", 2, anAnimal, namedAnimal);
    }
}
