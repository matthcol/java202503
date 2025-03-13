package basics.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.Collator;
import java.text.MessageFormat;
import java.util.*;

public class DemoStrings {

    @ParameterizedTest
    @ValueSource(strings = {"Montauban", "L'Haÿ-les-Roses"})
    void demoStringMethods(String city){
        System.out.println("Ville : " + city);

        // Méthode renvoyant 1 entier
        System.out.println("Nombre de lettres : " + city.length());

        // Méthodes renvoyant une nouvelle chaîne de caractères
        // Exercice: trouver la méthode adéquate du type String
        System.out.println("Majuscule : " + city.toUpperCase());
        System.out.println("Minuscule : " + city.toLowerCase());
        System.out.println("Code 3 premières lettres : " + city.substring(0, 3)); // Mon
        System.out.println("Les 3 suivantes : " + city.substring(3, 6)); // tau
        System.out.println("Les suivantes : " + city.substring(6)); // ban

        String code = city.substring(0, 3).toUpperCase();
        System.out.println("Code 3 premières lettres en majuscule: " + code);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            " Montauban",
            "Montauban ",
            "     Montauban    ",
            " \t\n\rMontauban\t \r\n ",
            " \t\n\rMontauban, ville du Tarn   et Garonne\t \r\n "
    })
    void demoTrim(String input){
        String inputCleaned = input.trim();
        System.out.println(MessageFormat.format("Saisie nettoyée: |{0}|", inputCleaned));
    }

    @Test
    void demoSplit(){
        String movieDescription = "Pulp Fiction,1994,154";
        String[] words = movieDescription.split(","); // tableau de 3 mots
        System.out.println("Nombre de mots: " + words.length);
        System.out.println(Arrays.toString(words));
        if (words.length == 3){
            String title = words[0]; // élément à la position 0
            String yearStr = words[1];
            String durationStr = words[2];
            int year = Integer.parseInt(yearStr);
            int duration = Integer.parseInt((durationStr));
            System.out.println(MessageFormat.format("titre = {0} ; année = {1} ; durée (mn) = {2}",
                    title, year, duration));
        } else {
            System.out.println("Nombre incorrect d'informations: attendu 3 obtenu " + words.length);
        }
        // System.out.println(words[3]); // java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // OK
            "Pulp Fiction",
            "Pulp Fiction,1994",
            "Pulp Fiction,1994,154",
            // KO
            "",
            "   \t \r\n \t",
            "Pulp Fiction,1994,154,blabla"
    })
    void demoPlusieursCasIf(String description){
        String[] words = description.split(",");
        if ((words.length == 1) && !words[0].isBlank()){
//        if ((words.length == 1) && !words[0].equals("")){
            System.out.println(MessageFormat.format("title = {0}", words[0]));
        } else if (words.length == 2){
            System.out.println(MessageFormat.format("title = {0} ; year = {1}", words[0], words[1]));
        } else if (words.length == 3) {
            System.out.println(MessageFormat.format("title = {0} ; year = {1} ; duration = {2}",
                    words[0], words[1], words[2]));
        } else {
            System.out.println("Trop ou pas assez d'informations");
        }
    }

    @Test
    void demoStringEquals(){
        // == vs .equals()
        String word1 = "Montauban";
        String word2 = "Mont";

        // == : égalité des adresses mémoires (En général à éviter !)
        System.out.println(word1 == "Montauban"); // true
        System.out.println(word1 == ("Mont" + "auban")); // true
        System.out.println(word1 == (word2 + "auban")); // false (aurait pu être vrai)

        // equals : égalité de contenu
        System.out.println(word1.equals("Montauban"));
        System.out.println(word1.toLowerCase().equals("montauban"));

        // spécifique aux chaînes de carcatères: equalsIgnoreCase
        System.out.println(word1.equalsIgnoreCase("montauban"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // OK
            "Pulp Fiction",
            "Pulp Fiction,1994",
            "Pulp Fiction,1994,154",
            // KO
            "Pulp Fiction,1994,154,blabla"
    })
    void demoPlusieursCasSwitchCase(String description) {
        String[] words = description.split(",");

        // instruction switch case (Java 1.0)
        // NB: valable pour les 8 types primitifs et depuis Java 7,  le type String
        switch (words.length){
            case 1:
                System.out.println(MessageFormat.format("title = {0}", words[0]));
                break;
            case 2:
                System.out.println(MessageFormat.format("title = {0} ; year = {1}", words[0], words[1]));
                break;
            case 3:
                System.out.println(MessageFormat.format("title = {0} ; year = {1} ; duration = {2}",
                        words[0], words[1], words[2]));
                break;
            default:
                System.out.println("Trop d'informations");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // OK
            "Pulp Fiction",
            "Pulp Fiction,1994",
            "Pulp Fiction,1994,154",
            "Pulp Fiction,1994,154,blabla",
            "Pulp Fiction,1994,154,blabla,blabla2",
            "Pulp Fiction,1994,154,blabla,blabla2,trop de blabla",
    })
    void demoPlusieursCasPatternMatching(String description) {
        String[] words = description.split(",");

        // instruction switch case en mode Pattern Matching (finalisé en Java 21)
        // https://docs.oracle.com/en/java/javase/21/language/pattern-matching.html
        switch (words.length){
            case 1 ->
                System.out.println(MessageFormat.format("title = {0}", words[0]));
            case 2 ->
                System.out.println(MessageFormat.format("title = {0} ; year = {1}", words[0], words[1]));
            case 3, 4, 5 -> // 3 ou 4 ou 5
                System.out.println(MessageFormat.format("title = {0} ; year = {1} ; duration = {2}",
                        words[0], words[1], words[2]));
            default ->
                System.out.println("Trop d'informations");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // OK
            "Pulp Fiction",
            "Pulp Fiction,1994",
            "Pulp Fiction,1994,154",
            "Pulp Fiction,1994,154,blabla",
            "Pulp Fiction,1994,154,blabla,blabla2",
            "Pulp Fiction,1994,154,blabla,blabla2,trop de blabla",
    })
    void demoPlusieursCasPatternMatchingValue(String description) {
        String[] words = description.split(",");

        // expression switch case en mode Pattern Matching (finalisé en Java 21)
        // retournant une valeur
        String display = switch (words.length){
            case 1 ->
                    MessageFormat.format("title = {0}", words[0]);
            case 2 ->
                    MessageFormat.format("title = {0} ; year = {1}", words[0], words[1]);
            case 3, 4, 5 -> // 3 ou 4 ou 5
                    MessageFormat.format("title = {0} ; year = {1} ; duration = {2}",
                            words[0], words[1], words[2]);
            default -> // couverture des cas exigée
                    "Warning: trop d'informations";
        };
        System.out.println(display);
    }

    @Test
    void testBoucleForI(){
        String description = "Pulp Fiction\t1994\t154\tLes vies de deux hommes de main, d'un boxeur, de la femme d'un gangster et de deux braqueurs s'entremêlent dans quatre histoires de violence et de rédemption";
        String[] infos = description.split("\t");

        // boucle classique du C: (initialisation; test continuité; instruction fin de boucle)
        for (int i = 0; i < infos.length; i++){  // NB: i++  =>  i = i + 1
            String info = infos[i];
            System.out.println(MessageFormat.format("Info #{0} : {1}", i + 1, info));
        }
        System.out.println();
        // boucle à l'envers: dernier au premier
        for (int i = infos.length - 1; i >= 0; i--){  // NB: i++  =>  i = i - 1
            String info = infos[i];
            System.out.println(MessageFormat.format("Info #{0} : {1}", i + 1, info));
        }
        System.out.println();
        // NB: opérateurs contractés: ++ -- += -= *= /= %=
        for (int i = 0; i < infos.length; i += 2){  // pas de 2 => i = i + 2
            String info = infos[i];
            System.out.println(MessageFormat.format("Info #{0} : {1}", i + 1, info));
        }
    }

    @Test
    void testBoucleForEach() {
        String description = "Pulp Fiction\t1994\t154\tLes vies de deux hommes de main, d'un boxeur, de la femme d'un gangster et de deux braqueurs s'entremêlent dans quatre histoires de violence et de rédemption";
        String[] infos = description.split("\t");
        // Boucle "foreach", syntaxe => for (variable de parcours: conteneur)
        // NB: "foreach" depuis Java 5
        for (String info: infos){
            System.out.println(MessageFormat.format("Info : {0}", info));
        }
    }

    @Test
    void testBoucleForEachJava11() {
        String description = "Pulp Fiction\t1994\t154\tLes vies de deux hommes de main, d'un boxeur, de la femme d'un gangster et de deux braqueurs s'entremêlent dans quatre histoires de violence et de rédemption";
        var infos = description.split("\t");
        // Boucle "foreach", syntaxe => for (variable de parcours: conteneur)
        for (var info: infos){
            System.out.println(MessageFormat.format("Info : {0}", info));
        }
    }

    @Test
    void testBoucleForEachFonctionnel() {
        String description = "Pulp Fiction\t1994\t154\tLes vies de deux hommes de main, d'un boxeur, de la femme d'un gangster et de deux braqueurs s'entremêlent dans quatre histoires de violence et de rédemption";
        var infos = description.split("\t");
        // Java 8:
        Arrays.stream(infos) // parcours du tableau en mode fonctionnel
                .forEach(info -> System.out.println(MessageFormat.format("Info : {0}", info)));
    }

    @Test
    void demo2DArray(){
        int[][] data = {{2, 23}, {32, 45}, {21, 78}}; // { ... } = tableau statique
        int nbRows = data.length;;
        int nbCols = data[0].length;
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                System.out.print(MessageFormat.format("{0, number, 000} ", data[i][j]));
            }
            System.out.println();
        }
    }

    // Tri

    @Test
    void demoTriTableau1(){
        String[] cities = {"Montauban", "Toulouse", "Pau", "Bordeaux", "Beaune", "Marseille", "Paris"};
        Arrays.sort(cities); // inplace sort
        System.out.println(Arrays.toString(cities));
    }

    @Test
    void demoTriTableau(){
        String[] wordsFr = {"été", "étuve", "étage", "cœur", "cobra", "Corde", "garçon", "gare", "garage", "zèbre"};
        Arrays.sort(wordsFr);
        System.out.println(Arrays.toString(wordsFr));

        System.out.println(Locale.getDefault()); // OK: fr_FR

        Locale localeFr = Locale.FRANCE; // constante
        System.out.println(localeFr);

        Locale localeEs = Locale.of("es", "ES");
        System.out.println(localeEs);

//        for (var locale: Locale.getAvailableLocales()){
//            System.out.println(locale);
//        }

        Collator collatorFr = Collator.getInstance(localeFr);
        Arrays.sort(wordsFr, collatorFr);
        System.out.println(Arrays.toString(wordsFr));

        String[] wordsEs = {"mañana", "matador", "mano", "llamar", "lagrima", "loco"};
        Collator collatorEs = Collator.getInstance(localeEs);
        Arrays.sort(wordsEs, collatorEs);
        System.out.println(Arrays.toString(wordsEs));

    }

    @Test
    void demoListeVilles(){
        List<String> cities = new ArrayList<>(); // liste vide
//        List<String> cities = new LinkedList<>(); // liste vide
        System.out.println(cities);

        cities.add("Montauban");
        cities.add("Toulouse");
        cities.add(0, "Pau");
        cities.add(1, "Bordeaux");
        System.out.println(cities);

        cities.set(0, "Marseille");
        System.out.println(cities);


        System.out.println();
        for (var city: cities){
            System.out.println(city);
        }
        System.out.println();

        var city = cities.get(2);
        System.out.println("Ville à l'indice 2: " + city);

        cities.remove(0);
        System.out.println(cities);
        cities.remove("Bordeaux");
        System.out.println(cities);
        cities.remove("Bordeaux");
        System.out.println(cities);

        cities.clear();
        System.out.println(cities);

        // cities.add(123); // E=String n'accepte pas des 'int'
    }

}





























































