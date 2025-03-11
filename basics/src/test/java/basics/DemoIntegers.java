package basics;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;


public class DemoIntegers {

    @Test
    void demoIntegers1() {
        // x et y sont des variables du type entier: 'int'
        int x = 3;
        int y = x + 2;
        System.out.println(y);
    }

    @Test
    void demoIntegers2() {
        int x = 31;
        int y = (x * 245) - (x / -3) + 42;
        System.out.println(y);
    }

    @Test
    void demoBigInteger(){
        // Le caractère '_' permet d'aérer l'écriture d'un nombre
        int x = 1_123_456_789;
        System.out.println(x);
    }

    @Test
    void demoLimitIntegers(){
        // type int: entier 32 bits signé:
        // intervalle -2 milliards (-2147483648) à + 2 milliards (2147483647)
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    void demoAllIntegerTypes(){
        short xs = 3; // 2 octets
        int xi = 2_345_345; // 4 octets
        long xl = 9_000_000_000_000_000_000L; // 8 octets
        System.out.println("Entier court : " + xs
                + " ; limite inf : " + Short.MIN_VALUE
                + " ; limite max : " + Short.MAX_VALUE);
        System.out.println(MessageFormat.format(
                "Entier : {0} ; limite inf : {1} ; limite sup : {2}",
                xi,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
        ));
        System.out.println(MessageFormat.format(
                "Entier long : {0} ; limite inf : {1} ; limite sup : {2}",
                xl,
                Long.MIN_VALUE,
                Long.MAX_VALUE
        ));
    }

    @Test
    void demoDivisionByZero(){
        int x = 3;
        int y = 4 / (3 - x);
        // => provoque une exception: java.lang.ArithmeticException: / by zero
        System.out.println(y);
    }

    @Test
    void demoDivision(){
        int x = 11;
        int q = x / 3; // => quotient entier 3
        int r = x % 3; // => reste de la division entière
        System.out.println(MessageFormat.format(
                "{0} / 3 => quotient = {1} et reste = {2}",
                x, q, r
        ));
        // NB: passer le diviseur en flottant pour avoir le résultat en flottant
        double qf = x / 3.0;
        System.out.println("Division en flottant: " + qf);
    }


} // fin de la classe
