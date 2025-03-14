package demo.cinema;

import cinema.adapter.MovieAdapter;
import cinema.data.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.CsvAdapter;
import utils.FilePathResourceUtils;

import java.util.List;
import java.util.function.Function;

public class StreamingMovie {

    static List<Movie> movieList;

    @BeforeAll
    static void initData(){
        movieList = CsvAdapter.readFileWithHeader(
                FilePathResourceUtils.pathFromResource(StreamingMovie.class, "/movies.tsv"),
                line -> MovieAdapter.fromCsvLine(line, "\t")
        );
    }

    @Test
    void demoStream1(){
        movieList.stream()
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    void demoStream2(){
        var totalDuration2000 = movieList.stream()
                .filter(movie -> movie.getYear() == 2000)
                .peek(movie -> System.out.println("After filter: " + movie))
                .mapToInt(Movie::getDuration)
                .peek(duration -> System.out.println("Durée : " + duration))
                .sum();
        System.out.println("Durée totale : " + totalDuration2000);
    }
}
