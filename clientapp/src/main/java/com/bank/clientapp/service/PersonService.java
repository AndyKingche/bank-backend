package com.bank.clientapp.service;

import java.util.*;

import com.bank.clientapp.model.PersonModel;


public interface PersonService {

    List<PersonModel> listPerson();
    Optional<PersonModel> personId(Long id);
    PersonModel createPerson(PersonModel person);
    Optional<PersonModel> updatePerson(Long id, PersonModel person);
    boolean deletePerson(Long id);
}
