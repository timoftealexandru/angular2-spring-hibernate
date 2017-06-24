package ro.ubb.catalog.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Rent;
import ro.ubb.catalog.web.controller.RentController;
import ro.ubb.catalog.web.dto.ClientDto;
import ro.ubb.catalog.web.dto.RentDto;
import ro.ubb.catalog.web.dto.RentsDto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nicu on 5/1/17.
 */


@Component
public class RentConverter extends BaseConverterGeneric<Rent, RentDto> {
    @Override
    public Rent convertDtoToModel(RentDto rentDto) {
        throw new RuntimeException("not yet implemented.");
    }

    @Override
    public RentDto convertModelToDto(Rent rent) {
        RentDto rentDto = RentDto.builder()
                .clientId(rent.getClient().getId())
                .movieId(rent.getMovie().getId())
                .noCopies(rent.getNoCopies())
                .build();
        return rentDto;
    }

    public Map<Long, Integer> convertDtoToMap(RentsDto rentsDto) {
        Map<Long, Integer> noCopies = new HashMap<>();
        rentsDto.getRents().stream().forEach(r-> noCopies.put(r.getClientId(),r.getNoCopies()));
        return noCopies;
    }
}
