package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Rent;
import ro.ubb.catalog.core.service.ClientService;
import ro.ubb.catalog.core.service.ClientService;
import ro.ubb.catalog.web.converter.RentConverter;
import ro.ubb.catalog.web.dto.RentDto;
import ro.ubb.catalog.web.dto.RentsDto;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nicu on 4/9/17.
 */

@RestController
public class RentController {
    private static final Logger log = LoggerFactory.getLogger(RentController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private RentConverter rentConverter;

    @RequestMapping(value = "/rents/{clientId}", method = RequestMethod.GET)
    public RentsDto getRents(
            @PathVariable final Long clientId) {
        log.trace("getRents: clientId={}", clientId);

        Client client = clientService.findClient(clientId);

        Set<Rent> rents = client.getRents();
        Set<RentDto> rentDtos = rentConverter
                .convertModelsToDtos(rents);


        RentsDto result = new RentsDto(rentDtos);

        log.trace("getRents: result={}", result);

        return result;
    }

    @RequestMapping(value = "/rents/{clientId}", method = RequestMethod.PUT)
    public RentsDto updateClientNoCopies(
            @PathVariable final Long clientId,
            @RequestBody final RentsDto rentsDto) {
        log.trace("updateClientNocpoies: clientid={}, rentsDto={}",
                clientId, rentsDto);

        Map<Long, Integer> noCopies = rentConverter.convertDtoToMap(rentsDto);
        Client client = clientService.updateClientNoCopies(clientId,noCopies);

        Set<RentDto> rentDtos = rentConverter.
                convertModelsToDtos(client.getRents());
        RentsDto result = new RentsDto(rentDtos);

        log.trace("getRents: result={}", result);

        return result;
    }

}
