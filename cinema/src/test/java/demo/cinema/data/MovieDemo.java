package demo.cinema.data;

import cinema.data.Movie;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MovieDemo {

    @Test
    void demoMovie(){
        var movie = new Movie();
        System.out.println(movie); // idem ligne suivante
        System.out.println(movie.toString());
        System.out.println(movie.getTitle());

        movie.setTitle("E.T.");
        System.out.println(movie);
    }

    @Test
    void demoMovieAllArgsConstructor(){
        short year = 1982;
        var movie1 = new Movie(1, "E.T.", year, (short) 105, "Un gentil extraterrestre....", null);
        System.out.println(movie1);
    }

    @Test
    void demoMovieBuilder(){
        var movie1 = Movie.builder()
                .id(1)
                .title("E.T")
                .year((short) 1982)
                .build();
        var movie2 = Movie.builder()
                .id(2)
                .title("Un P'tit Truc En Plus")
                .year((short) 2024)
                .duration((short) 99)
                .synopsis("Pour échapper à la police, un fils et son père trouvent refuge dans une colonie de vacances pour jeunes adultes handicapés, en se faisant passer pour un pensionnaire et son éducateur.")
                .posterUri("https://m.media-amazon.com/images/M/MV5BZTAwODk4M2UtNjEyZC00Y2QzLWJlZDEtNjY2YmE5NGExMzVjXkEyXkFqcGc@._V1_FMjpg_UY4724_.jpg")
                .build();

        // Mieux d'avoir un toString succint
        Stream.of(movie1, movie2)
                .forEach(System.out::println);

        // On peut chercher les éléments à la demande
        System.out.println();
        Stream.of(movie1, movie2)
                .forEach(movie -> System.out.println(
                        movie.getTitle()
                        + " : "
                        + movie.getSynopsis()
                ));
    }

    @Test
    void demoConstante(){
        System.out.println(Movie.MIN_YEAR);
        // Movie.MIN_YEAR = 1955; // Cannot assign a value to final variable 'MIN_YEAR'
    }

}