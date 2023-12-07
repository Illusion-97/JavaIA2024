package objects;

// On utilise des classes pour représenter des concepts qu'on fera interagir dans le programme
public abstract class Animal {
// Une classe abstraite définit un concept abstrait, il permet la création d'instance enfant, mais directement la sienne
    //Pour être utilisée, une classe abstraite DOIT être héritée
    private static long count = 0;
    public enum AgeRange { // est statique par défaut
        JEUNE,ADULTE,SENIOR
    }
    // Jeune : age < 3 / Senior : age >= 6

    /*
    * Lorsqu'une variable est déclarée directement dans une classe, il s'agit d'un attribut, une information qui définit la classe
    * Dans ce contexte on ajoute plusieurs informations aux attributs, et principalement la visibilité
    * public : un attribut public est accessible n'importe où dans le programme
    * default : est accessible uniquement dans le même package
    * private : n'est accessible QUE dans la classe elle-même
    * protected : fonctionne comme la visibilité default mais également les classes 'enfant' en dehors du package
    * */
    public final long id;
    private int age;
    protected String name;
    // final n'est pas une visibilité, que la valeur ne sera pas modifiée une fois initialisée
    final Animal[] parents;

    // constructeur vide : {visibilité} {NomDeLaClasse}({paramètres})
    public Animal() {
        System.out.println("Construction d'un animal");
        count++;
        id = count;
        parents = new Animal[2]; // un attribut final doit être initialisé dans le constructeur
        // [null, null]
        Veterinaire.declarer(this);
        if (this instanceof Chien) FightClub.inscrire((Chien) this);
    }

    public Animal(String name) {
        this(); // force le passage par le constructeur vide
        // 'this' fait référence à l'objet actuel
        this.name = name;
    }

    public Animal (String name, int age, Animal parent, Animal otherParent) {
        this(name); // force le passage par un constructeur acceptant le même nombre d'arguments de même type
        this.age = age;
        this.parents[0] = parent;
        this.parents[1] = otherParent;
    }

    // Une méthode (fonction) est une définition d'un comportement à exécuter
    // {visibilité} {type de retour} {nom}({paramètres})
    /*public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge() {
        age++;
    }

    */
    public void happyBirthday() {
        age++;
        System.out.printf("Happy Birthday %s : %d an(s)%n", name, age);
    }

    public AgeRange getAgeRange() {
        if (age < 3) return AgeRange.JEUNE;
        else if (age >= 6) return AgeRange.SENIOR;
        else return AgeRange.ADULTE;

        // return age < 3 ? AgeRange.JEUNE : (age >= 6 ? AgeRange.SENIOR : AgeRange.ADULTE);
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract Animal getChild(Animal otherParent);
}
