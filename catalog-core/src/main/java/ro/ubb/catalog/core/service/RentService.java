package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Rent;

import java.util.List;
import java.util.Set;

/**
 * Created by Nicu on 4/9/17.
 */
public interface RentService {

    List<Rent> findAll();

    Rent createRent(Integer clientCnp,String movieTitle, Integer noCopies);

    Rent updateRent(Long rentId, Integer clientCnp, String movieTitle,Integer noCopies);

    void deleteRent(Long rentId);
}