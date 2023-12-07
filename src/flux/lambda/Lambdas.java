package flux.lambda;

public class Lambdas {
    public static void main(String[] args) {
        Stringifier stringifier = new Stringifier();
        soutCurrencyAmount(stringifier);
    }

    private static void soutCurrencyAmount(CurrencyStringifier stringifier) {
        double amount = 143.98765432;
        System.out.println(stringifier.convert(amount));
    }
}
