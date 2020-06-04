package com.gardeos.gardenos.controller;

import com.gardeos.gardenos.entity.Client;
import com.gardeos.gardenos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ClientRest {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    List<Client> getClients(){
        return clientService.getClient();
    }

}
