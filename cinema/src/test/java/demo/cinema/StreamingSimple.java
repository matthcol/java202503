package demo.cinema;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class StreamingSimple {

    @Test
    void demoStreamString(){
        var titles = List.of(
                "E.T.",
                "Un P'tit Truc En Plus",
                "Eternal Sunshine of the Spotless Mind",
                "Les Gardiens de la Galaxie 3",
                "Avatar",
                "Le 5e Element",
                "Les Tontons flingueurs"
        );
        titles.stream()
                .forEach(System.out::println);
        System.out.println();
        // => simplification
        titles.forEach(System.out::println);

        System.out.println();
        var titlesUpper = titles.stream()
                .map(title -> title.toUpperCase()) // se simplifie en String::toUpperCase
                .toList(); // collecte
        System.out.println(titlesUpper);

        System.out.println();
        var titlesUL = titles.stream()
                .filter(title -> title.startsWith("L"))
                .map(String::toUpperCase)
                .toList();
        System.out.println(titlesUL);

        var countTitleL = titles.stream()
                .filter(title -> title.startsWith("L"))
                .count();
        System.out.println("Nb titres commençant par L: " + countTitleL);

        var totalLetters = titles.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(totalLetters);
    }

    @Test
    void demoGenerator(){
        var listResults = IntStream.range(0,10)
                .peek(x -> System.out.println("Etape 1 (range) : " + x))
                .map(x -> x * x + 1)
                .peek(x -> System.out.println("Etape 2 (map): " + x))
                .boxed()
                .toList();
    }


}
