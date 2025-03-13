package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

public class CsvAdapter {

    public static <T> List<T> readFileWithHeader(Path path, Function<String,T> adapter){
        try (var stream = Files.lines(path)) {
            return stream
                    .skip(1) // omit headers
                    .map(adapter)
                    .toList();
            // auto close file in any case (ok or error)
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file:" + path, e);
        }
    }
}
