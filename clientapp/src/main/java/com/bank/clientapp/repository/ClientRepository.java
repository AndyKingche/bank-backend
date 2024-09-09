package com.bank.clientapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.clientapp.model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    
}
