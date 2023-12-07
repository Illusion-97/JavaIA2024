package objects;

public class Jardin {
    public static void main(String[] args) {
        /*Animal anAnimal = new Animal();
        System.out.println("anAnimal.id = " + anAnimal.id);
        Animal anotherAnimal = new Animal();
        System.out.println("anotherAnimal.id = " + anotherAnimal.id);
        Animal namedAnimal = new Animal("Petiot");
        System.out.println("namedAnimal.id = " + namedAnimal.id);
        System.out.println("namedAnimal.name = " + namedAnimal.name);
        Animal animalErrant = new Animal("Errant", 3, null, null);
        System.out.println("animalErrant.getAgeRange() = " + animalErrant.getAgeRange());
        Animal pedigree = new Animal("Pedigree", 2, anAnimal, namedAnimal);
        animalErrant.happyBirthday();*/
        /*System.out.println(pedigree.getAge());
        animalErrant.setAge(52);
        System.out.println(animalErrant.getAge());*/
        BergerAllemand bergerAllemand = new BergerAllemand();
        bergerAllemand.displayPride();
        Malinois era = new Malinois("Era", 3, null, null);
        Animal animalBerger = new BergerAllemand("Rex", 8, null, null);
        if(animalBerger instanceof BergerAllemand) {
            /*BergerAllemand castBergerFromAnimal = (BergerAllemand) animalBerger;
            castBergerFromAnimal.displayPride();*/
            ((BergerAllemand) animalBerger).displayPride();
        }

        Animal animalMalouf = new Malinois("Malouf", 5, null, null);
        Veterinaire.checkUp();

        BergerAllemand typeBerger = new BergerAllemand("typeBerger");
        Malinois typeMalinois = new Malinois("typeMalinois");
        Animal typeAnimal = typeBerger;
        Chien typeChien = typeBerger;
        BergerAllemand typeBergerCast = (BergerAllemand) typeChien;
        typeBergerCast.displayPride();
        System.out.println();

        checkUp(typeBerger);
        checkUp(typeMalinois);
        promener(typeBerger);
        promener(typeMalinois);

        typeBerger.displayPride();
        System.out.println("C'est la fête !");
        typeMalinois.bark();
        typeBerger.bark();

        System.out.println("C'est l'heure du du ... !");
        FightClub.annonce();
        System.out.println("\n");
        era.fight(typeMalinois);
        System.out.println("\n");
        bergerAllemand.fight(typeBerger);
        System.out.println("\n");
        era.fight(typeBerger);
        System.out.println("\n");
        typeBerger.fight(typeMalinois);

        FightClub.startTournament();
    }


    private static void checkUp(Animal animal) {
        System.out.println(animal.getAgeRange());
    }

    private static void promener(Chien chien) {
        chien.bark();
    }
}
