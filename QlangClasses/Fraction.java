package QlangClasses;

public class Fraction {
    private Integer numerator;
    private Integer denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    public static Fraction addFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.denominator
                + fraction2.numerator * fraction1.denominator;
        int newDenominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction subtractFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.denominator
                - fraction2.numerator * fraction1.denominator;
        int newDenominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction multiplyFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.numerator;
        int newDenominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction divideFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.denominator;
        int newDenominator = fraction1.denominator * fraction2.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction simplifyFraction(Fraction fraction) {
        int gcd = 1;
        int smaller = Math.min(Math.abs(fraction.numerator), Math.abs(fraction.denominator));

        for (int i = 2; i <= smaller; i++) {
            if (fraction.numerator % i == 0 && fraction.denominator % i == 0) {
                gcd = i;
            }
        }
        return new Fraction(fraction.numerator / gcd, fraction.denominator / gcd);
    }

    @Override
    public String toString() {
        if (this.denominator == 0) {
            return "null";
        }
        return ((double) this.numerator / this.denominator) * 100 + "%";
    }
}
