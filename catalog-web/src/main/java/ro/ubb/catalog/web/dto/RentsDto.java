package ro.ubb.catalog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.catalog.core.model.Rent;

import java.util.List;
import java.util.Set;

/**
 * Created by paul on 4/9/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentsDto {
    private Set<RentDto> rents;
}