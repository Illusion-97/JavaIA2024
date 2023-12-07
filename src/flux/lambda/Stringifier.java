package flux.lambda;

public class Stringifier implements CurrencyStringifier {
    @Override
    public String convert(double amount) {
        return String.format("%.2f €", amount); // 143.99 €
    }
}
