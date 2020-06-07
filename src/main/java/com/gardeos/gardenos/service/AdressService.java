package com.gardeos.gardenos.service;

import com.gardeos.gardenos.entity.Adress;
import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.paggination.AdressRepositoryPaggination;
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
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdressRepositoryPaggination adressRepositoryPaggination;

    public Iterable<Adress> getAllAdresses(){
        return adressRepository.findAll();
    }

    public Adress getAdress(Long id){
        return adressRepository.findById(id).orElse(null);
    }

    public List<Adress> getPagginationAdress(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Adress> pagedResult = adressRepositoryPaggination.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Adress>();
        }
    }

    public void addAdress(Adress newAdress){
        if(clientRepository.existsById(newAdress.getClient().getId())){
            adressRepository.save(newAdress);
        }
    }

    public void deleteAdress(Long id) {
        adressRepository.deleteById(id);
    }

    public void adressUpdate(Adress adressToUpdate, Long id) {
        Adress updatedAdress = adressToUpdate;
        updatedAdress.setId(id);
        adressRepository.save(updatedAdress);
    }

    public void addClientWithAdress(Adress adress) {
        Client client = adress.getClient();
        clientRepository.save(client);
        adressRepository.save(adress);
    }
}
