package cinema.data;

import lombok.*;

// @Data // bien pour débuter, pour personnaliser utiliser @Getter, @Setter, ...
@Getter @Setter
@ToString(of = {"id", "title", "year"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private int id;
    private String title;  // JEE Bean Validation: @NotNull, @NotBlank
    private short year;
    private Short duration;
    private String synopsis;
    private String posterUri;

}
