package com.bank.clientapp.service;

import java.util.List;
import java.util.Optional;

import com.bank.clientapp.DTO.ClientDTO;
import com.bank.clientapp.model.ClientModel;


public interface ClientService {

    List<ClientModel> listClient();
    Optional<ClientModel> clientId(Long id);
    ClientModel createClient(ClientDTO clientDTO);
    Optional<ClientModel> updateClient(Long id, ClientDTO clientDTO);
    boolean deleteClient(Long id);

}
