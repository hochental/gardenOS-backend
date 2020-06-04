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

