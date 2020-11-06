package com.felipe.osworks.osworksapi.controller;

import com.felipe.osworks.osworksapi.domain.model.Client;
import com.felipe.osworks.osworksapi.domain.repository.ClientRepository;
import com.felipe.osworks.osworksapi.domain.service.ClientRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientRegisterService clientRegister;

    @GetMapping
    public List<Client> list(){
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> find(@PathVariable Long clientId){
        Optional<Client>client = clientRepository.findById(clientId);
        if(client.isPresent()){
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@Valid @RequestBody Client client){
        return clientRegister.save(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody Client client){
        if(!clientRepository.existsById(clientId)){
           return ResponseEntity.notFound().build();
        }
        client.setId(clientId);
        client = clientRegister.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId){
        if(!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }
        clientRegister.delete(clientId);
        return ResponseEntity.noContent().build();
    }


}
