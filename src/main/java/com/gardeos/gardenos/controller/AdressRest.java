package com.gardeos.gardenos.controller;

import com.gardeos.gardenos.entity.Adress;
import com.gardeos.gardenos.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class AdressRest {

    @Autowired
    AdressService adressService;

    @GetMapping("/adresses")
    public Iterable<Adress> getAllAdresses(){
        return adressService.getAllAdresses();
    }

}

