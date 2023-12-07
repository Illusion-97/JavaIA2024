package flux.lambda;

// @FunctionalInterface : représente une interface n'ayant qu'une méthode pour permettre une syntaxe simplifiée (lambda)
public interface CurrencyStringifier {
    String convert(double amount);
}
