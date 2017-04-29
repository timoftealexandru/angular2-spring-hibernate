package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Client;

import java.util.List;
import java.util.Set;

/**
 * Created by Nicu on 4/9/17.
 */
public interface ClientService {

    List<Client> findAll();

    Client updateClient(Long clientId, String name, Integer cnp);

    Client createClient(String name, Integer cnp);

    void deleteClient(Long clientId);


}
