package ro.ubb.catalog.web.dto;

import lombok.*;

/**
 * Created by Nicu on 4/24/17.
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto extends BaseDto {
    private String name;
    private Integer cnp;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cnp='" + cnp +
                "} " + super.toString();
    }


}
