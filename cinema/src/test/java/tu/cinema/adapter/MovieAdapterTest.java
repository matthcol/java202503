package tu.cinema.adapter;

import cinema.adapter.MovieAdapter;
import cinema.data.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieAdapterTest {

    @Test
    void testFromCsvLine(){
        String line = "5257\tExcuse Me\t1915\t50\tHenry Mallory, U.S.A., receives orders ...\thttps://1foto.org/superposter.png";
        Movie movie = MovieAdapter.fromCsvLine(line, "\t");
        assertNotNull(movie);
        assertAll(
                () -> assertEquals(5257, movie.getId(), "id"),
                () -> assertEquals("Excuse Me", movie.getTitle(), "title"),
                () -> assertEquals((short) 1915, movie.getYear(), "year"),
                () -> assertEquals((short) 50, movie.getDuration(), "duration"),
                () -> assertEquals("Henry Mallory, U.S.A., receives orders ...",
                        movie.getSynopsis(), "synopsis"),
                () -> assertEquals("https://1foto.org/superposter.png",
                        movie.getPosterUri(), "posterUri")
        );
    }

    // TODO: test all cases with optional fields duration, synopsis, posterUri

}