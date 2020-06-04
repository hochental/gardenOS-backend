package com.gardeos.gardenos.service;

import com.gardeos.gardenos.entity.Adress;
import com.gardeos.gardenos.repository.AdressRepository;
import com.gardeos.gardenos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    public AdressRepository adressRepository;

    @Autowired
    public ClientRepository clientRepository;

    public Iterable<Adress> getAllAdresses(){
        return adressRepository.findAll();
    }

    public Adress getAdress(Long id){
        return adressRepository.findById(id).orElse(null);
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
}
