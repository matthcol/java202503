package tu.cinema.adapter;

import cinema.adapter.MovieAdapter;
import cinema.data.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieAdapterTest {

    @Test
    void testFromCsvLine(){
        String line = "5257\tExcuse Me\t1915\t50\tHenry Mallory, U.S.A., receives orders to join his regiment which is to embark for the Philippines. The Overland Limited is the only train that will enable him to reach the coast in time to escape a court-martial. Having a little time to spare he persuades Marjorie to elope with him and reserves two berths. They reach the train in time, but haven't time to get married. \"Little\" Jimmy Wellington, who stands six feet two and weighs 350 in his stocking feet, guzzles too much, so his wife takes the Overland for Reno, telling him she goes to Paris for the year. He gets sore and takes the same train for the same place and for the same purpose. The Reverend Doctor Temple, tiring of the Monotony of Ypsilanti elopes and takes the Overland to the coast. There is another girl aboard, a former sweetheart of Mallory's. With this cargo in charge of a worthy porter, they start. The happenings en route are screamingly funny. Marjorie, not married to Mallory, has her reputation at stake. Dr. Temple knows this, but won't let anyone know that he's a preacher of the gospel. Wellington and his wife fail to meet because he's too busy pestering the men folks and she puffing cigars. Then the other girl pesters Marjorie and Mallory with a bracelet she received from Mallory, and so everyone does something that had been better left undone, and the porter must bear the brunt of it all. A hold-up relieves the girl of the bracelet and the arrival of the Mormon minister when they get to Utah frightens Temple into practicing his profession of the young couple. Then a cinder in Wellington's eye causes him to meet his wife who relieves him of it, and they patch up their differences. With everything running smoothly, we leave them to continue their journeys.\thttps://m.media-amazon.com/images/M/MV5BMmVmMGE0ZTYtZWEwNC00ODFlLTg3YTQtNTA0ZGQ4MmY2YTE0XkEyXkFqcGdeQXVyMDUyOTUyNQ@@._V1_SY150_CR46,0,101,150_.jpg";
        Movie movie = MovieAdapter.fromCsvLine(line, "\t");
        assertNotNull(movie);
        assertAll(
                () -> assertEquals(5257, movie.getId(), "id"),
                () -> assertEquals("Excuse Me", movie.getTitle(), "title"),
                () -> assertEquals((short) 1915, movie.getYear(), "year"),
                () -> assertEquals((short) 50, movie.getDuration(), "duration"),
                () -> assertEquals("Henry Mallory, U.S.A., receives orders to join his regiment which is to embark for the Philippines. The Overland Limited is the only train that will enable him to reach the coast in time to escape a court-martial. Having a little time to spare he persuades Marjorie to elope with him and reserves two berths. They reach the train in time, but haven't time to get married. \"Little\" Jimmy Wellington, who stands six feet two and weighs 350 in his stocking feet, guzzles too much, so his wife takes the Overland for Reno, telling him she goes to Paris for the year. He gets sore and takes the same train for the same place and for the same purpose. The Reverend Doctor Temple, tiring of the Monotony of Ypsilanti elopes and takes the Overland to the coast. There is another girl aboard, a former sweetheart of Mallory's. With this cargo in charge of a worthy porter, they start. The happenings en route are screamingly funny. Marjorie, not married to Mallory, has her reputation at stake. Dr. Temple knows this, but won't let anyone know that he's a preacher of the gospel. Wellington and his wife fail to meet because he's too busy pestering the men folks and she puffing cigars. Then the other girl pesters Marjorie and Mallory with a bracelet she received from Mallory, and so everyone does something that had been better left undone, and the porter must bear the brunt of it all. A hold-up relieves the girl of the bracelet and the arrival of the Mormon minister when they get to Utah frightens Temple into practicing his profession of the young couple. Then a cinder in Wellington's eye causes him to meet his wife who relieves him of it, and they patch up their differences. With everything running smoothly, we leave them to continue their journeys.",
                        movie.getSynopsis(), "synopsis"),
                () -> assertEquals("https://m.media-amazon.com/images/M/MV5BMmVmMGE0ZTYtZWEwNC00ODFlLTg3YTQtNTA0ZGQ4MmY2YTE0XkEyXkFqcGdeQXVyMDUyOTUyNQ@@._V1_SY150_CR46,0,101,150_.jpg",
                        movie.getPosterUri(), "posterUri")
        );
    }

}