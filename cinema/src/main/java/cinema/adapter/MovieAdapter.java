package cinema.adapter;

import cinema.data.Movie;

public class MovieAdapter {

    /**
     * Parse a CSV line into a Movie object.
     * Fields are separated by delimiter sep
     * @param csvLine line of a CSV file with fields
     * @param sep CSV separator
     * @return movie object created
     * @throws NumberFormatException if any numeric field has the wrong format
     */
    public static Movie fromCsvLine(String csvLine, String sep){
        String[] words = csvLine.split(sep,-1);
        int id = Integer.parseInt(words[0]);
        String title = words[1];
        short year = Short.parseShort(words[2]);
        Short duration = words[3].isEmpty() ? null : Short.parseShort(words[3]);
        String synopsis = words[4].isEmpty() ? null : words[4];
        String posterUri = words[5].isEmpty() ? null : words[5];
        return Movie.builder()
                .id(id)
                .title(title)
                .year(year)
                .duration(duration)
                .synopsis(synopsis)
                .posterUri(posterUri)
                .build();
    }
}
