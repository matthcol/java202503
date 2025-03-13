package basics.demo;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.text.MessageFormat;
import java.util.*;

public class DemoCollections {

    @Test
    void demoListCreation(){
        // Java 1.2
        List words0 = new ArrayList();
        // Java 5: programmation générique
        // List<E> avec E=String
        List<String> words1 = new ArrayList<String>();

        // Java 7: notation diamond => pas besoin de répeter le paramétre générique
        List<String> words2 = new ArrayList<>();
        Collections.addAll(words2, "Marseille", "Lyon", "Bordeaux");
        System.out.println("Liste de mots (2) : " + words2);

        // Java 11
        var words3 = new ArrayList<String>();
        var words4 = List.of("Montauban", "Pau", "Toulouse", "Lille"); // utile pour les tests unitaires
        // NB: List.of
        // * il existe de la même manière Set.of, Map.of, ...
        // * WARNING: collection non modifiable

        System.out.println("Liste de mots (4) : " + words4);

        // reversement d'une collection vers une autre
        words3.addAll(words2);
        words3.addAll(words4);
        System.out.println("Liste de mots (3) : " + words3);

        // autre constructeur
        var words5 = new ArrayList<String>(words3);
        System.out.println("Liste de mots (5) : " + words5);

        // List.of: cadeau empoisonné
        // words4.add("Bayonne"); // UnsupportedOperationException
        System.out.println(words4.getClass()); // => class java.util.ImmutableCollections$ListN

        // Rappel des méthodes principales d'une liste:
        // accès par index (add, get, set, remove)
        String word2 = words5.get(2);
        System.out.println("Mot à l'indice 2 : " + word2);

        // Exercice 1: parcourir et afficher tous les mots en majuscule
        System.out.println();
        // for (String word: words5){
        for (var word: words5){
            System.out.println(word.toUpperCase());
        }

        // Exercice 2: parcourir à l'envers et  afficher tous les mots en majuscule
        for (var word: words5.reversed()){
            System.out.println(word.toUpperCase());
        }
    }

    @Test
    void demoSet(){
        var list_words = List.of("Marseille", "Lyon", "Bordeaux", "Montauban", "Pau", "Toulouse", "Lille");

        // ensemble
        Set<String> set_words = new HashSet<>(list_words);
        System.out.println(set_words);

        System.out.println();
        String word0 = list_words.get(0);
        System.out.println(word0.hashCode());

        System.out.println();
        for (var word: set_words){
            System.out.println(MessageFormat.format(
                    "Mot = {0} ; hashCode = {1}",
                    word,
                    word.hashCode()
            ));
        }

        System.out.println();
        set_words.add("Pau");
        set_words.add("Paris");
        set_words.add("Paris");
        System.out.println(set_words);

        System.out.println();
        boolean ok = set_words.add("Beaune");
        System.out.println("Ajout effectué : " + ok);
        ok = set_words.add("Beaune");
        System.out.println("Ajout effectué : " + ok);
        System.out.println(set_words);

        // reverser dans un treeset
        // NB: utilise ordre par défaut des String (Natural Order)
        NavigableSet<String> sortedset_words = new TreeSet<>(set_words);
        System.out.println(sortedset_words);

        sortedset_words.add("Nantes"); // au bon endroit (en fonction de l'ordre défini)
        System.out.println(sortedset_words);

        System.out.println();
        for (var word: sortedset_words){ // du + petit au plus grand
            System.out.println(word);
        }

        System.out.println();
        for (var word: sortedset_words.reversed()){ // du + grand au plus petit
            System.out.println(word);
        }

        System.out.println();
        var extract = sortedset_words.subSet("B", true, "N", false);
        System.out.println("Villes de B à M : " + extract);

        System.out.println();
        var extract2 = sortedset_words.tailSet("N");
        System.out.println("Villes à partir de N : " + extract2);
        // NB: en dessous => méthode headSet
    }

    @Test
    void demoSortedSetLanguage(){
        var words = Set.of(
                "artichaud", "Animal",
                "été", "étuve", "étage",
                "cœur", "cobra", "Corde",
                "garçon", "gare", "garage",
                "zèbre"
        );

        var collatorFr = Collator.getInstance(Locale.FRANCE);

        // reverser les éléments dans une liste modifiable et un ensemble trié modifiable
        List<String> list_words = new ArrayList<>(words);
        list_words.sort(collatorFr); // coût tri: O(n * log(n))

        NavigableSet<String> sortedset_word = new TreeSet<>(collatorFr); // ensemble vide avec ordre custom
        sortedset_word.addAll(words);

        System.out.println("Liste triée : " + list_words);
        System.out.println("Ensemble trié : " + sortedset_word);

        // ajout d'un élément
        String newWord = "bébé";
        list_words.add(newWord); // à la fin
        sortedset_word.add(newWord);  // au bon endroit (en fonction de l'ordre défini au début)
        System.out.println();
        System.out.println("Liste (après ajout) : " + list_words);
        System.out.println("Ensemble trié (après ajout) : " + sortedset_word);

        list_words.sort(collatorFr);
        System.out.println();
        System.out.println("Liste (retriée) : " + list_words);

        list_words.sort(collatorFr.reversed());
        System.out.println();
        System.out.println("Liste (tri FR inversé) : " + list_words);
    }

    @Test
    void demoCollectionNumbers(){
        List<Integer> numbers = List.of(12, 34, 45, 66, 77, 88, 99, 98, 76, 54, 32, 21);

        List<Integer> list_numbers = new ArrayList<>(numbers);
        NavigableSet<Integer> sortedset_numbers = new TreeSet<>(numbers); // natural order: croissant
        System.out.println("liste : " + list_numbers);
        System.out.println("ensemble trié : " + sortedset_numbers);

        Collections.sort(list_numbers); // tri ordre naturel
        System.out.println("liste triée: " + list_numbers);

        sortedset_numbers.add(48); // emballage auto: .add(new Integer(48))
        System.out.println("ensemble trié (après ajout) : " + sortedset_numbers);

        int nb = sortedset_numbers.first(); // déballage auto: appel à .intValue()
        System.out.println("Nombre déballé : " + nb);
    }
}




