package basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DemoOtherPrimitives {

    @Test
    void demoBooleans(){
        // type boolean: true, false
        int x = 3;
        boolean ok = x > 1;
        System.out.println(ok);

        // 3 combinaisons logiques
        //  or:   ||
        //  and:  &&
        //  not:  !

        // 6 tests classiques sur les types primitifs
        boolean ok2 = (x == 3)
                || (x != 3)
                || (x > 3)
                || (x >= 3)
                || (x < 3)
                || (x <= 3);
        System.out.println(ok2);

        ok2 = !(ok2 && ok);
        System.out.println(ok2);
    }

    @ParameterizedTest
    @ValueSource(ints={1, 3, 5}) // le test sera déclenché 3 fois pour x = 1, x=3 puis x =5
    void demoBooleans2(int x){
        System.out.println("Soit x = " + x);
        System.out.println("- x == 3 : " + (x == 3));
        System.out.println("- x != 3 : " + (x != 3));
    }

    @Test
    void demoCharacter(){
        char c = 'A';
        System.out.println(c);
        c = '東';
        System.out.println(c);

        String texte = "Montauban";
        System.out.println(texte);
        System.out.println(texte.length());

        char letter = texte.charAt(0);
        System.out.println(letter); // 1ère lettre (position 0)
    }
}




















