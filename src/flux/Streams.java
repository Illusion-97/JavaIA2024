package flux;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        String[] months = DateFormatSymbols.getInstance().getMonths();

        for (String month : months) System.out.println(month);

        // Consumer : prends un paramètre d'un type, et ne retourne rien (void)
        Arrays.stream(months).forEach(month -> System.out.println(month));
        Arrays.stream(months).forEach(System.out::println);

        // Les streams permettent d'enchainer des actions jusqu'à une opération dite 'terminale'
        List<String> monthsList = Arrays.stream(months).toList();

        monthsList.stream()
                // map transforme les données dans le flux en fonction de la lambda passée en argument
                //.map(month -> month.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("Mois dont la taille du nom est égale à 4");
        monthsList.stream()
                // filter récupère des données en fonction d'une condition (boolean)
                // Predicat : prends un paramètre et attends un booleen en retour
                .filter(month -> month.length() == 4)
                .forEach(System.out::println);

        System.out.println("Nombre de String vide dans la liste : " +
                        monthsList.stream()
                                //.filter(month -> month.isEmpty())
                                .filter(String::isEmpty)
                                .count()
                );

        String emptyString = "";
        String blankString = "     "; // emptyString.isBlank() : true

        System.out.println("Remplacer monthList par une liste contenant les mois non 'Blank'");
        // pour inverser une condition dans un predicat, il n'est pas possible de faire un passage 'Method Reference'
        monthsList = monthsList.stream().filter(month -> !month.isBlank()).toList();

        // Afficher sur une ligne : mars, avril, mai, juin, août
        System.out.println(monthsList.stream()
                .filter(month -> month.length() <= 5)
                .collect(Collectors.joining(", ")));

        // Est-ce que la liste contient au moins une valeur avec un caractère spécial
        System.out.println("Est-ce que la liste contient au moins une valeur avec un caractère spécial : " +
                // anyMatch(condition) <-> filter(condition).count() > 0
                monthsList.stream().anyMatch(month -> !month.matches("[a-z]*")));

        System.out.println("Nombre total de lettres : " +
                        monthsList.stream()
                                // Convertir un String en Integer correspondant à sa taille
                                // .map(month -> month.length())
                                .map(String::length)
                                // réduire l'ensemble des éléments de la liste en un seul du même type
                                // identity : valeur de départ, suivi de la méthode de calcul
                                // syntaxe de lambda (paramètres) -> corps de méthode
                                //.reduce(0, (a,b) -> a + b)
                                //.reduce(0, Integer::sum)
                                .mapToInt(Integer::intValue)
                                .sum()
                );

        // Solution collect
        System.out.println(monthsList.stream().collect(Collectors.joining("")).length());

        System.out.println("Les 3 mois ayant le plus grand nombre de lettres : ");
        monthsList.stream()
                // Le tri se base sur une valeur numérique :
                // négative indique que l'élément doit être placé avant le suivant
                // positive : doit être après
                // 0 : position indifférente
                .sorted((currentMonth,nextMonth) -> nextMonth.length() - currentMonth.length())
                .limit(3)
                .forEach(System.out::println);

        monthsList.stream()
                //.sorted((currentMonth,nextMonth) -> currentMonth.length() - nextMonth.length())
                .sorted(Comparator.comparingInt(String::length))
                .skip(monthsList.size() - 3)
                .forEach(System.out::println);

    }
}
