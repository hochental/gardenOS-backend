package com.gardeos.gardenos.service;

import com.gardeos.gardenos.entity.Adress;
import com.gardeos.gardenos.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    public AdressRepository adressRepository;

    public Iterable<Adress> getAllAdresses(){
        return adressRepository.findAll();
    }

}
