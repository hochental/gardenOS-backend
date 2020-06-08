package com.gardeos.gardenos.controller;

import com.gardeos.gardenos.entity.Adress;
import com.gardeos.gardenos.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AdressRest {

    @Autowired
    AdressService adressService;

    @GetMapping("/all/adresses")
    public Iterable<Adress> getAllAdresses(){
        return adressService.getAllAdresses();
    }

    @GetMapping("/adress/{id}")
    public Adress getAllAdresses(@PathVariable(name = "id") Long id){
        return adressService.getAdress(id);
    }

    @GetMapping("/adresses")
    public ResponseEntity<List<Adress>> getAllAdresses(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Adress> list = adressService.getPagginationAdress(pageNo, pageSize, sortBy);
        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", "10");
        return new ResponseEntity<List<Adress>>(list, headers, HttpStatus.OK);
    }

    @PostMapping("/adress")
    public void addAdress(@RequestBody Adress adress){ //need to add ID of Client <gonna be igonored with get>
        adressService.addAdress(adress);
    }

    @PostMapping("/client-full")
    void addClientWithAdress(@RequestBody Adress adress){
        System.out.println(adress);
        System.out.println(adress.getClient());
        adressService.addClientWithAdress(adress);
    }

    @DeleteMapping("/adress/{id}")
    public void deleteAdress(@PathVariable(name = "id") Long id){
        adressService.deleteAdress(id);
    }

    @PutMapping("/adress/{id}")
    public void adressUpdate(@RequestBody Adress adressToUpdate, @PathVariable(name = "id") Long id){
        System.out.println(adressToUpdate + " id: "+ id);
        adressService.adressUpdate(adressToUpdate, id);
    }


}

