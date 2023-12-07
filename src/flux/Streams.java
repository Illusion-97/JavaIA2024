package flux;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;

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

        System.out.println("Remplacer monthList par une liste contenant les mois non 'Blank'");
        // pour inverser une condition dans un predicat, il n'est pas possible de faire un passage 'Method Reference'
        monthsList = monthsList.stream().filter(month -> !month.isBlank()).toList();

        // Afficher sur une ligne : mars, avril, mai, juin, août
    }
}
