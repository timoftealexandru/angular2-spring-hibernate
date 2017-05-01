package ro.ubb.catalog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created by paul on 4/29/2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto extends BaseDto {
    private String name;
    private String director;
    private String genre;
    private Integer availableCopies;

    @Override
    public String toString() {
        return "Movie{" +
                //  "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", available copies =" + availableCopies +
                "} " + super.toString();
    }
}
