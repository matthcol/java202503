package basics.demo;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

// NB: pour du calcul exact (finance) => utiliser la classe BigDecimal
public class DemoFloats {

    @Test
    void demoFloatSimplePrecision(){
        float x = 3.2f; // suffixe f => float (simple precision)
        System.out.println(x);
    }

    @Test
    void demoFloatDoublePrecision(){
        double x = 3.2;
        double y = 1.0;
        double z = 3E240; // exposant: 'e' ou 'E'
        double w = -1.345E-123;
        System.out.println(MessageFormat.format(
                "Nombres : {0}, {1}, {2}, {3}",
                x, y, z, w
        ));
        System.out.println(z);
        // 1 calcul mélangeant flottant et entier bascule en flottant
        double res = z / (x * y) + w - 1;
        System.out.println(res);
        double res2 = z * 1E70;
        System.out.println(res2); // Inf
        System.out.println(-res2); // -Inf
        System.out.println(res2 * 2); // toujours l'infini
        System.out.println(res2 / res2); // NaN = Not a Number
        System.out.println(1.0 / 0.0); // +Inf
        System.out.println(0.0 / 0.0); // NaN
        System.out.println(1.0 / res2); // 0.0
    }
}
