package com.bank.clientapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import com.bank.clientapp.DTO.ClientDTO;
import com.bank.clientapp.model.ClientModel;
import com.bank.clientapp.model.PersonModel;
import com.bank.clientapp.repository.ClientRepository;
import com.bank.clientapp.service.impl.ClientServiceImpl;

@SpringBootApplication
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
public class ClientIntegrationTest {
    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testCreateClient() {

    
        PersonModel person = new PersonModel();
        person.setId(1L);
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setPersonid(2);
        clientDTO.setPassword("password123");
        clientDTO.setStatus(true);

  
        ClientModel createdClient = clientService.createClient(clientDTO);

  
        Assertions.assertThat(createdClient).isNotNull();
        Assertions.assertThat(createdClient.getId()).isNotNull();
        Assertions.assertThat(createdClient.getPassword()).isEqualTo("password123");
        Assertions.assertThat(createdClient.getStatus()).isEqualTo(true);

        clientRepository.deleteById(createdClient.getId());
    }
}
