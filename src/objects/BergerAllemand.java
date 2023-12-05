package objects;

public class BergerAllemand extends Animal {
    private int pride = 10;

    public BergerAllemand() { // S'il n'est pas précisé, super() est implicite

    }

    public BergerAllemand(String name) {
        super(name); // Animal(String name)
    }

    public BergerAllemand(String name, int age, Animal parent, Animal otherParent) {
        super(name, age, parent, otherParent);
    }

    public void displayPride() {
        System.out.println(name + " démontre sa fierté : " + "WOUF! ".repeat(pride));
    }
}
