package com.gardeos.gardenos.service;

import com.gardeos.gardenos.entity.Client;
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

    public List<Client> getClient(){
        List<Client> clientList = new ArrayList<Client>();

        for(Client client: clientRepository.findAll()){
            client.setAdressList(adressRepository.findAllByClientId(client.getId()));
            clientList.add(client);
        }

        return clientList;
    }

}
