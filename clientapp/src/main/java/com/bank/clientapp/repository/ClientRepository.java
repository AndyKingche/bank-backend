package com.bank.clientapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.clientapp.model.ClientModel;
import com.bank.clientapp.model.PersonModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    Optional<ClientModel> findByPersonid(PersonModel personid);
}
