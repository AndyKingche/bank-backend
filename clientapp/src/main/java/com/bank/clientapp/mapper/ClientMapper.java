package com.bank.clientapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.bank.clientapp.DTO.ClientDTO;
import com.bank.clientapp.model.ClientModel;
import com.bank.clientapp.model.PersonModel;

@Mapper
public interface ClientMapper {

     ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "personid", target = "personid", qualifiedByName = "personToPersonId")
    ClientDTO clientModelToClientDTO(ClientModel clientModel);

    @Mapping(source = "personid", target = "personid", qualifiedByName = "personIdToPerson")
    ClientModel clientDTOToClientModel(ClientDTO clientdto);

    @Named("personToPersonId")
    default Long mapPersonToPersonId(PersonModel person) {
        return person != null ? person.getId() : null;
    }


    @Named("personIdToPerson")
    default PersonModel mapPersonIdToPerson(Long id) {
        if (id == null) return null;
        PersonModel person = new PersonModel();
        person.setId(id);
        return person;
    }

}
