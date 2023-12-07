package flux.lambda;

public class Lambdas {
    public static void main(String[] args) {
        Stringifier stringifier = new Stringifier();
        soutCurrencyAmount(stringifier);

        // création d'une classe qui implémente l'interface CurrencyStringifier
        // Ici on s'épargne la création d'un fichier pour réaliser une implémentation
        CurrencyStringifier cs = new CurrencyStringifier() {
            @Override
            public String convert(double amount) {
                return String.format("%.2f $", amount);
            }
        };
        soutCurrencyAmount(cs);

        // Same as
        CurrencyStringifier currencyStringifier = amount -> String.format("%.2f $", amount);
        soutCurrencyAmount(currencyStringifier);

        // Same as
        soutCurrencyAmount(amount -> String.format("%.2f £", amount));
        soutCurrencyAmount(amount -> String.format("%.4f €", amount));
        soutCurrencyAmount(amount -> String.format("%.1f $", amount));

        soutCurrencyAmount(amount -> String.valueOf(amount));
        // Passage par Method Reference
        soutCurrencyAmount(String::valueOf);
    }

    private static void soutCurrencyAmount(CurrencyStringifier stringifier) {
        double amount = 143.98765432;
        System.out.println(stringifier.convert(amount));
    }
}
