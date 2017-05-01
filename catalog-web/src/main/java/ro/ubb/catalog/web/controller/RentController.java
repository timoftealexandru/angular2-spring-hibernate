package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.ubb.catalog.core.model.Rent;
import ro.ubb.catalog.core.model.Rent;
import ro.ubb.catalog.core.service.RentService;
import ro.ubb.catalog.core.service.RentService;
import ro.ubb.catalog.web.converter.RentConverter;
import ro.ubb.catalog.web.dto.RentDto;
import ro.ubb.catalog.web.dto.RentsDto;
import ro.ubb.catalog.web.dto.EmptyJsonResponse;
import ro.ubb.catalog.web.dto.RentsDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nicu on 4/9/17.
 */
@RestController
public class RentController {

    private static final Logger log = LoggerFactory.getLogger(RentController.class);

    @Autowired
    private RentService rentService;

    @Autowired
    private RentConverter rentConverter;

    @RequestMapping(value = "/rents", method = RequestMethod.GET)
    public RentsDto getRents() {
        log.trace("getRents");

        List<Rent> rents = rentService.findAll();

        log.trace("getRents: rents={}", rents);

        return new RentsDto(rentConverter.convertModelsToDtos(rents));
    }

    @RequestMapping(value = "/rents/{rentId}", method = RequestMethod.PUT)
    public Map<String, RentDto> updateRent(
            @PathVariable final Long rentId,
            @RequestBody final Map<String, RentDto> rentDtoMap) {
        log.trace("updateRent: rentId={}, rentDtoMap={}", rentId, rentDtoMap);

        RentDto rentDto = rentDtoMap.get("rent");
        Rent rent = rentService.updateRent(rentId, rentDto.getClientCnp(),rentDto.getMovieTitle(),rentDto.getNoCopies());

        Map<String, RentDto> result = new HashMap<>();
        result.put("rent", rentConverter.convertModelToDto(rent));

        log.trace("updateRents: result={}", result);

        return result;
    }

    @RequestMapping(value = "/rents", method = RequestMethod.POST)
    public Map<String, RentDto> createRent(
            @RequestBody final Map<String, RentDto> rentDtoMap) {
        log.trace("createRent: rentDtoMap={}", rentDtoMap);

        RentDto rentDto = rentDtoMap.get("rent");
        Rent rent = rentService.createRent(
                rentDto.getClientCnp(),rentDto.getMovieTitle(),rentDto.getNoCopies());

        Map<String, RentDto> result = new HashMap<>();
        result.put("rent", rentConverter.convertModelToDto(rent));

        log.trace("updateRent: result={}", result);

        return result;
    }

    @RequestMapping(value = "rents/{rentId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRent(@PathVariable final Long rentId) {
        log.trace("deleteRent: rentId={}", rentId);

        rentService.deleteRent(rentId);

        log.trace("deleteRent - method end");

        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }
}
