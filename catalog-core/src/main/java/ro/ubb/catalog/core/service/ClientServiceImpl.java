package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.repository.ClientRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nicu on 4/9/17.
 */
@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        log.trace("findAll");

        List<Client> clients = clientRepository.findAll();

        log.trace("findAll: clients={}", clients);

        return clients;
    }

    @Override
    @Transactional
    public Client updateClient(Long clientId, String name, Integer cnp) {
        log.trace("updateClient: clientId={}, name={}, cnp={}",
                clientId, name, cnp);

        Client client = clientRepository.findOne(clientId);
        client.setName(name);
        client.setCnp(cnp);

        log.trace("updateClient: client={}", client);

        return client;
    }

    @Override
    public Client createClient(String name, Integer cnp) {
        log.trace("createClient: name={}, cnp={}",
                 name, cnp);

        Client client = new Client( name, cnp);
        client = clientRepository.save(client);

        log.trace("createClient: client={}", client);

        return client;
    }

    @Override
    public void deleteClient(Long clientId) {
        log.trace("deleteClient: clientId={}", clientId);

        clientRepository.delete(clientId);

        log.trace("deleteClient - method end");
    }


}
