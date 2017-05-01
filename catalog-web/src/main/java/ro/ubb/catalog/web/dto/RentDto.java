package ro.ubb.catalog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.catalog.core.model.Rent;

import javax.persistence.Column;

/**
 * Created by Nicu on 5/1/17.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentDto extends BaseDto {

    private int clientCnp;

    private String movieTitle;

    private int noCopies;


    public String toString() {
        return "Rent{" +
                "clientCnp='" + clientCnp + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", no of copies='" + noCopies + '\'' +
                "} " + super.toString();
    }


}
