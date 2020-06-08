package com.gardeos.gardenos.service;

import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.exception.RequestException;
import com.gardeos.gardenos.paggination.ClientRepositoryPaggination;
import com.gardeos.gardenos.repository.AdressRepository;
import com.gardeos.gardenos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    ClientRepositoryPaggination clientRepositoryPaggination;

    public List<Client> getClients(){
            List<Client> clientList = new ArrayList<Client>();
            for (Client client : clientRepository.findAll()) {
                client.setAdressList(adressRepository.findAllByClientId(client.getId()));
                clientList.add(client);
            }
            return clientList;
    }

    public Client getClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        client.setAdressList(adressRepository.findAllByClientId(client.getId()));
        return client;
    }

    public List<Client> getPagginationClient(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        List<Client> clientList = new ArrayList<Client>();

        Page<Client> pagedResult = clientRepositoryPaggination.findAll(paging);

        for (Client client : pagedResult) {
            client.setAdressList(adressRepository.findAllByClientId(client.getId()));
            clientList.add(client);
        }

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Client>();
        }
    }

    public void removeClient(Client newClient) {
        adressRepository.deleteAll(adressRepository.findAllByClientId(newClient.getId()));
        clientRepository.delete(newClient);
    }

    public void removeClient(Long id) {
        adressRepository.deleteAll(adressRepository.findAllByClientId(id));
        clientRepository.deleteById(id);
    }

    public void addClient(Client newClient) {
        clientRepository.save(newClient);
    }

    public Boolean checkIfClientExist(Client newClient) {
        return !clientRepository.findByEmail(newClient.getEmail()).isPresent()
                && !clientRepository.findByTelephoneNumber(newClient.getTelephoneNumber()).isPresent();
    }
}




