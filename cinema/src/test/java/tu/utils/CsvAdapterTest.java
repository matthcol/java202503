package tu.utils;

import org.junit.jupiter.api.Test;
import utils.CsvAdapter;
import utils.FilePathResourceUtils;

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
}