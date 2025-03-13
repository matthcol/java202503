package basics;

/**
 * Play with numbers
 */
public class NumberGame {

    /**
     * compute the greatest common divider between two natural integers (>0)
     * @param a first integer, must be strictly positive
     * @param b second integer, must be strictly positive
     * @return greatest common divider
     * @throws IllegalArgumentException if a or b is negative or 0
     */
    public static int pgcd(int a, int b){
        // https://fr.wikipedia.org/wiki/Algorithme_d%27Euclide
        // version d'origine d'Euclide
        if ((a <= 0) || (b <=0)) throw new IllegalArgumentException("argument must be strictly positive");
        while (a != b) {
            if (a > b) a = a - b;
            else b = b -a;
        } // fin while
        return a;

        // NB: while fait au moins 1 fois
        // do {
        //
        // } while (true);

        // En version prototype
//        throw new UnsupportedOperationException("not implemented yet");
//        return 0;
    } // fin fonction pgcd

    /**
     * compute the greatest common divider between two natural integers (>0)
     * @param a first integer, must be strictly positive
     * @param b second integer, must be strictly positive
     * @return greatest common divider
     * @throws IllegalArgumentException if a or b is negative or 0
     */
    public static int pgcd1(int a, int b){
        // https://fr.wikipedia.org/wiki/Algorithme_d%27Euclide
        // version modulo
        if ((a <= 0) || (b <=0)) throw new IllegalArgumentException("argument must be strictly positive");
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        } // fin while
        return a;
    }
} // fin class NumberGame
