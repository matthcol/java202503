package tu.utils;

import org.junit.jupiter.api.Test;
import utils.CsvAdapter;
import utils.FilePathResourceUtils;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class CsvAdapterTest {

    @Test
    void testReadFileWithHeader() {
        CsvAdapter.readFileWithHeader(
                FilePathResourceUtils.pathFromResource(CsvAdapterTest.class, "/movies.tsv"),
                Function.identity()
        )
                .stream()
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    void testSplitString(){
        String line = "1,aa,19,,,";
        var words = line.split(",", -1);
        System.out.println(Arrays.toString(words));
    }
}