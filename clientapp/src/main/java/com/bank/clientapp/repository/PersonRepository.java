package com.bank.clientapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.clientapp.model.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {

    Optional<PersonModel> findByIdentification(String identification);
}
