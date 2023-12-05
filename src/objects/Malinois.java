package objects;

public class Malinois extends Animal {
    public Malinois() {
    }

    public Malinois(String name) {
        super(name);
    }

    public Malinois(String name, int age, Animal parent, Animal otherParent) {
        super(name, age, parent, otherParent);
    }
}
