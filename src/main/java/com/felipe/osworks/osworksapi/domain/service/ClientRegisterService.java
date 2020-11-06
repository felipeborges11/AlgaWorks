package com.felipe.osworks.osworksapi.domain.service;

import com.felipe.osworks.osworksapi.domain.exception.BusinessException;
import com.felipe.osworks.osworksapi.domain.model.Client;
import com.felipe.osworks.osworksapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientRegisterService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        Client clientExist = clientRepository.findByEmail(client.getEmail());

        if(clientExist != null && !clientExist.equals(client)){
            throw new BusinessException("Email already registered.");
        }
        return clientRepository.save(client);
    }

    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }


}
