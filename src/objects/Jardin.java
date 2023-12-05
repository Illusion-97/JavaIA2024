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
    }
}
