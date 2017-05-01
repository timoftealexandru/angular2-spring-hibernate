package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Rent;
import ro.ubb.catalog.core.repository.RentRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nicu on 4/9/17.
 */
@Service("rentServiceImpl")
public class RentServiceImpl implements RentService {

    private static final Logger log = LoggerFactory.getLogger(RentServiceImpl.class);

    @Autowired
    private RentRepository rentRepository;

    @Override
    public List<Rent> findAll() {
        log.trace("findAll");

        List<Rent> rents = rentRepository.findAll();

        log.trace("findAll: rents={}", rents);

        return rents;
    }

    @Override
    @Transactional
    public Rent updateRent(Long rentId,  Integer clientCnp, String movieName, Integer noCopies) {
        log.trace("updateRent: rentId={}, movieName={}, clientCnp={}, noCopies={}",
                rentId, movieName,clientCnp, noCopies);

        Rent rent = rentRepository.findOne(rentId);
        rent.setMovieTitle(movieName);
        rent.setClientCnp(clientCnp);
        rent.setNoCopies(noCopies);
        log.trace("updateRent: rent={}", rent);

        return rent;
    }

    @Override
    public Rent createRent( Integer clientCnp,String movieTitle,Integer noCopies) {
        log.trace("createRent: movieTitle={}, clientCnp={}, noCopie={}",
                movieTitle, clientCnp, noCopies);

        Rent rent = new Rent(clientCnp,movieTitle,noCopies);
        rent = rentRepository.save(rent);

        log.trace("createRent: rent={}", rent);

        return rent;
    }

    @Override
    public void deleteRent(Long rentId) {
        log.trace("deleteRent: rentId={}", rentId);

        rentRepository.delete(rentId);

        log.trace("deleteRent - method end");
    }


}
