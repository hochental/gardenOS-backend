package com.gardeos.gardenos.controller;

import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ClientRest {

    @Autowired
    ClientService clientService;

    @GetMapping("/all/clients")
    List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/client/{id}")
    public Client getAllAdresses(@PathVariable(name = "id") Long id){
        return clientService.getClient(id);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Client> list = clientService.getPagginationClient(pageNo, pageSize, sortBy);
        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", "10");
        return new ResponseEntity<List<Client>>(list, headers, HttpStatus.OK);
    }

    @PostMapping("/client")
    String addClient(@RequestBody Client newClient){
        clientService.addClient(newClient);
    return "operation done";
    }

    @DeleteMapping("/client")
    String deleteClient(@RequestBody Client clientToRemove){
        clientService.removeClient(clientToRemove);
    return "operation done";
    }

    @DeleteMapping("/client/{id}")
    String deleteClient(@PathVariable Long id){
        clientService.removeClient(id);
        return "operation done";
    }

}
