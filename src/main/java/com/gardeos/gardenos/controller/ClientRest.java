package com.gardeos.gardenos.controller;

import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ClientRest {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/client")
    String addClient(@RequestBody Client newClient){
        clientService.addClient(newClient);
    return "operation done";
    }

    @GetMapping("/client/{id}")
    public Client getAllAdresses(@PathVariable(name = "id") Long id){
        return clientService.getClient(id);
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
