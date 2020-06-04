package com.gardeos.gardenos.service;

import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.exception.RequestException;
import com.gardeos.gardenos.repository.AdressRepository;
import com.gardeos.gardenos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AdressRepository adressRepository;

    public List<Client> getClients(){
            List<Client> clientList = new ArrayList<Client>();
            for (Client client : clientRepository.findAll()) {
                client.setAdressList(adressRepository.findAllByClientId(client.getId()));
                clientList.add(client);
            }
            return clientList;
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).orElse(null);
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
}




