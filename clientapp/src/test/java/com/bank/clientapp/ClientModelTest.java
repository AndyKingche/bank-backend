package com.bank.clientapp;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bank.clientapp.model.ClientModel;
import com.bank.clientapp.model.PersonModel;

public class ClientModelTest {

    @Test
    void testClientModelGettersAndSetters() {
  
        ClientModel client = new ClientModel();
        
    
        client.setId(1L);
        client.setPassword("password123");
        client.setStatus(true);
        
    
        PersonModel person = new PersonModel();
        person.setId(2L);
        client.setPersonid(person);

      
        Assertions.assertThat(client.getId()).isEqualTo(1L);
        Assertions.assertThat(client.getPassword()).isEqualTo("password123");
        Assertions.assertThat(client.getStatus()).isEqualTo(true);
        Assertions.assertThat(client.getPersonid()).isNotNull();
        Assertions.assertThat(client.getPersonid().getId()).isEqualTo(2L);
    }
}
