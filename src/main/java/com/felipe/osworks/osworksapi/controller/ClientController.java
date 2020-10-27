package com.felipe.osworks.osworksapi.controller;

import com.felipe.osworks.osworksapi.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> list(){
        var client1 = new Client();
        client1.setId(1L);
        client1.setName("Felipe");
        client1.setEmail("felipebsilva5@gmail.com");
        client1.setPhone("99 99999-9999");

        var client2 = new Client();
        client2.setId(2L);
        client2.setName("Borges");
        client2.setEmail("borges@mail.com");
        client2.setPhone("88 88888-8888");

        return Arrays.asList(client1,client2);
    }
}
