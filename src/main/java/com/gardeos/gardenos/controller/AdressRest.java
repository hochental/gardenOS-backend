package com.gardeos.gardenos.controller;

import com.gardeos.gardenos.entity.Adress;
import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class AdressRest {

    @Autowired
    AdressService adressService;

    @GetMapping("/adresses")
    public Iterable<Adress> getAllAdresses(){
        return adressService.getAllAdresses();
    }

    @GetMapping("/adress/{id}")
    public Adress getAllAdresses(@PathVariable(name = "id") Long id){
        return adressService.getAdress(id);
    }

    @PostMapping("/adress")
    public String addAdress(@RequestBody Adress adress){ //need to add ID of Client <gonna be igonored with get>
        adressService.addAdress(adress);
        return "operation done";
    }

    @DeleteMapping("/adress/{id}")
    public String deleteAdress(@PathVariable(name = "id") Long id){
        adressService.deleteAdress(id);
        return "operation done";
    }

    @PutMapping("/adress/{id}")
    public String adressUpdate(@RequestBody Adress adressToUpdate, @RequestParam(name = "id") Long id){
        adressService.adressUpdate(adressToUpdate, id);
        return "operation done";
    }


}

