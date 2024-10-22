package com.bank.clientapp.service.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.clientapp.DTO.ClientDTO;
import com.bank.clientapp.mapper.ClientMapper;
import com.bank.clientapp.model.ClientModel;
import com.bank.clientapp.model.PersonModel;
import com.bank.clientapp.repository.ClientRepository;
import com.bank.clientapp.service.ClientService;
import com.bank.clientapp.service.PersonService;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientrepository;

    @Autowired
    PersonService personService;

    @Override
    public List<ClientModel> listClient() {
        return clientrepository.findAll();
    }

    @Override
    public Optional<ClientModel> clientId(Long id) {

        return clientrepository.findById(id).map(clientFound ->{
            return Optional.of(clientFound);
        }).orElseThrow(()-> new EntityNotFoundException("Client not found with ID: " + id));

    }

    @Override
    public ClientModel createClient(ClientDTO clientDTO) {
       try {



        ClientModel client = ClientMapper.INSTANCE.clientDTOToClientModel(clientDTO);

        Optional<PersonModel> personExists = personService.personId(client.getPersonid().getId());
        Optional<ClientModel> clientExists = clientrepository.findByPersonid(client.getPersonid());

        if(!clientExists.isPresent()){
            
            if(personExists.isPresent()){
    
                return clientrepository.save(client);
            }
            else{
    
                throw new IllegalArgumentException("The person with the id does not exist : " + client.getPersonid().getId());
            }

        }else{
            throw new IllegalArgumentException("La persona ya es un cliente con el ID " + client.getPersonid().getId());
        }

       }
       catch (Exception e) {
        throw new RuntimeException("Error processing create client request: "+ e);
       }
    }

    @Override
    public Optional<ClientModel> updateClient(Long id, ClientDTO clientDTO) {

        ClientModel createdClient = ClientMapper.INSTANCE.clientDTOToClientModel(clientDTO);

        return clientId(id).map(clientFound -> {
           
            if(clientDTO.getPersonid() != null){

                long personId = clientDTO.getPersonid();
                Optional<PersonModel> personExists = personService.personId(personId);

                if(personExists.isPresent()){
                    
                    if(createdClient.getPassword() != null){
                        clientFound.setPassword(createdClient.getPassword());
                    }
                    if(createdClient.getPersonid().getId() != null){
                        clientFound.setPersonid(createdClient.getPersonid());
                    }
                    if(createdClient.getStatus() != null){
                        clientFound.setStatus(createdClient.getStatus());

                    }
                  
                    clientrepository.save(clientFound);
    
                }
            }


            return Optional.of(clientFound);
            

        }).orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + id));
    }

    @Override
    public boolean deleteClient(Long id) {

        return clientId(id).map(client -> {
            clientrepository.delete(client);
            return true;
        }).orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + id));
    }

    

}
