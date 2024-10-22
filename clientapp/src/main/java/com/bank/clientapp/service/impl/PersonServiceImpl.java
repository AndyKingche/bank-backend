package com.bank.clientapp.service.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bank.clientapp.model.PersonModel;
import com.bank.clientapp.service.PersonService;
import com.bank.clientapp.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<PersonModel> listPerson() {
       
        return personRepository.findAll();
    }

    @Override
    public Optional<PersonModel> personId(Long id) {

         return personRepository.findById(id).map(personFound -> {
            return Optional.of(personFound);
         }).orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        
    }

    @Override
    public PersonModel createPerson(PersonModel person) {


        System.out.println(person.getIdentification());

        Optional<PersonModel> personexisting = personRepository.findByIdentification(person.getIdentification()); 

        if (personexisting.isPresent()) {
            throw new IllegalArgumentException("La persona con cédula " + person.getIdentification() + " ya está registrada.");
        }
        return personRepository.save(person);
    }

    @Override
    public Optional<PersonModel> updatePerson(Long id, PersonModel person) {
         
        return personId(id).map(personFound -> {
        personFound.setName(person.getName());
        personFound.setGender(person.getGender());
        personFound.setAge(person.getAge());
        personFound.setIdentification(person.getIdentification());
        personFound.setAddress(person.getAddress());
        personFound.setPhone(person.getPhone());
        personRepository.save(personFound);
        return Optional.of(personFound);
    }).orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
        
    }

    @Override
    public boolean deletePerson(Long id) {

        return personId(id).map(person -> {
            personRepository.delete(person);
            return true;
        }).orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + id));
    
    }

}
