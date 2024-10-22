package com.bank.clientapp.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.clientapp.model.ClientModel;
import com.bank.clientapp.model.PersonModel;
import com.bank.clientapp.service.ClientService;
import com.bank.clientapp.service.PersonService;
import com.bank.clientapp.DTO.ClientDTO;
import com.bank.clientapp.DTO.PersonDTO;
import com.bank.clientapp.messages.MessagesDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/clientapp/")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PersonService personService;
    
    /**
     * Person
     */

     @GetMapping("list-person")
     public ResponseEntity<List<PersonModel>> getAllListPerson(){
        try {
            List<PersonModel> result = personService.listPerson();

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
        
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
     }

     @GetMapping("person/{id}")
     public ResponseEntity<?> getPersonId(@PathVariable("id") Long id){
         
         try {
             
             Optional<PersonModel> result = personService.personId(id);
        

                return new ResponseEntity<>(result, HttpStatus.OK);


        }
        catch (Exception e) {

            MessagesDTO badMessagedto = new MessagesDTO();

            badMessagedto.setMessage(e.getMessage() );
            badMessagedto.setMethod("GET");
            badMessagedto.setStatus(false);
                return new ResponseEntity<>(badMessagedto, HttpStatus.BAD_REQUEST); 
        }
     }

     @PostMapping("create-person")
     public ResponseEntity<MessagesDTO> createPerson(@RequestBody PersonModel person){

        try {
            
           PersonModel createdPerson = personService.createPerson(person);

            MessagesDTO menssagedto = new MessagesDTO();

            menssagedto.setMessage("Person created with ID "+ createdPerson.getId());
            menssagedto.setMethod("POST");
            menssagedto.setStatus(true);

            return new ResponseEntity<>(menssagedto, HttpStatus.CREATED);
            
        } catch(IllegalArgumentException e){

            MessagesDTO badMessagedto = new MessagesDTO();

            badMessagedto.setMessage("Invalid input: " + e.getMessage());
            badMessagedto.setMethod("POST");
            badMessagedto.setStatus(false);

            return new ResponseEntity<>(badMessagedto, HttpStatus.BAD_REQUEST
            );
        } 
        catch (Exception e) {

            MessagesDTO badMessagedto = new MessagesDTO();

            badMessagedto.setMessage("Error" + e.getMessage());
            badMessagedto.setMethod("POST");
            badMessagedto.setStatus(false);

            return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

     }

     @PutMapping("person-edit/{id}")
     public ResponseEntity<MessagesDTO> updatePerson(@PathVariable("id") Long id, @RequestBody PersonModel personModel) {

        try {
            
            Optional<PersonModel> updatedPerson = personService.updatePerson(id, personModel);

             MessagesDTO menssagedto = new MessagesDTO();
 
             menssagedto.setMessage("Person updated with ID "+ updatedPerson.get().getId());
             menssagedto.setMethod("PUT");
             menssagedto.setStatus(true);
 
             return new ResponseEntity<>(menssagedto, HttpStatus.OK);
             
         } catch(IllegalArgumentException e){
 
             MessagesDTO badMessagedto = new MessagesDTO();
 
             badMessagedto.setMessage("Invalid input: " + e.getMessage());
             badMessagedto.setMethod("PUT");
             badMessagedto.setStatus(false);
 
             return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
         } 
         catch (Exception e) {
 
             MessagesDTO badMessagedto = new MessagesDTO();
 
             badMessagedto.setMessage("Error: " + e.getMessage());
             badMessagedto.setMethod("PUT");
             badMessagedto.setStatus(false);
 
             return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
         }
      
     }

     @DeleteMapping("person-delete/{id}")
     public ResponseEntity<MessagesDTO> deletePerson(@PathVariable("id") Long id){
        try {
            
            
            personService.deletePerson(id);

            
            MessagesDTO menssagedto = new MessagesDTO();
 
             menssagedto.setMessage("Person delete with ID "+ id);
             menssagedto.setMethod("DELETE");
             menssagedto.setStatus(true);
 
             return new ResponseEntity<>(menssagedto, HttpStatus.OK);


        } catch (Exception e) {

            MessagesDTO badMessagedto = new MessagesDTO();
 
            badMessagedto.setMessage("Error : " + e.getMessage());
            badMessagedto.setMethod("PUT");
            badMessagedto.setStatus(false);

            return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

     }

    /**Client
     * 
     */
    @GetMapping("list-client")
    public ResponseEntity<List<ClientModel>> getAllListClient() {
        try {
            List<ClientModel> result = clientService.listClient();

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }  
    }

    @GetMapping("client/{id}")
    public ResponseEntity<?> getClientId(@PathVariable("id") Long id){
        
        try {
            
            Optional<ClientModel> result = clientService.clientId(id);
       

               return new ResponseEntity<>(result, HttpStatus.OK);


       }
       catch (Exception e) {

           MessagesDTO badMessagedto = new MessagesDTO();

           badMessagedto.setMessage(e.getMessage() );
           badMessagedto.setMethod("GET");
           badMessagedto.setStatus(false);
               return new ResponseEntity<>(badMessagedto, HttpStatus.BAD_REQUEST); 
       }
    }

    @PostMapping("create-client")
    public ResponseEntity<MessagesDTO> createClient(@RequestBody ClientDTO client){

       try {
           
         
          ClientModel createdClient = clientService.createClient(client);

           MessagesDTO menssagedto = new MessagesDTO();

           menssagedto.setMessage("Client created with ID "+ createdClient.getId());
           menssagedto.setMethod("POST");
           menssagedto.setStatus(true);

           return new ResponseEntity<>(menssagedto, HttpStatus.CREATED);
           
       } catch(IllegalArgumentException e){

           MessagesDTO badMessagedto = new MessagesDTO();

           badMessagedto.setMessage("Invalid input: " + e.getMessage());
           badMessagedto.setMethod("POST");
           badMessagedto.setStatus(false);

           return new ResponseEntity<>(badMessagedto, HttpStatus.BAD_REQUEST);
       } 
       catch (Exception e) {

           MessagesDTO badMessagedto = new MessagesDTO();

           badMessagedto.setMessage("Error" + e.getMessage());
           badMessagedto.setMethod("POST");
           badMessagedto.setStatus(false);

           return new ResponseEntity<>(badMessagedto, HttpStatus.BAD_REQUEST);
       }

    }

    @PutMapping("client-edit/{id}")
    public ResponseEntity<MessagesDTO> updateClient(@PathVariable("id") Long id, @RequestBody ClientDTO client) {

       try {
           
           Optional<ClientModel> updatedClient = clientService.updateClient(id, client);

            MessagesDTO menssagedto = new MessagesDTO();

            menssagedto.setMessage("Client updated with ID "+ updatedClient.get().getId());
            menssagedto.setMethod("PUT");
            menssagedto.setStatus(true);

            return new ResponseEntity<>(menssagedto, HttpStatus.OK);
            
        } catch(IllegalArgumentException e){

            MessagesDTO badMessagedto = new MessagesDTO();

            badMessagedto.setMessage("Invalid input: " + e.getMessage());
            badMessagedto.setMethod("PUT");
            badMessagedto.setStatus(false);

            return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        catch (Exception e) {

            MessagesDTO badMessagedto = new MessagesDTO();

            badMessagedto.setMessage("Error: " + e.getMessage());
            badMessagedto.setMethod("PUT");
            badMessagedto.setStatus(false);

            return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
    }

    @DeleteMapping("client-delete/{id}")
    public ResponseEntity<MessagesDTO> deleteClient(@PathVariable("id") Long id){
       try {
           
           
           clientService.deleteClient(id);

           
           MessagesDTO menssagedto = new MessagesDTO();

            menssagedto.setMessage("Client delete with ID "+ id);
            menssagedto.setMethod("DELETE");
            menssagedto.setStatus(true);

            return new ResponseEntity<>(menssagedto, HttpStatus.OK);


       } catch (Exception e) {

           MessagesDTO badMessagedto = new MessagesDTO();

           badMessagedto.setMessage("Error : " + e.getMessage());
           badMessagedto.setMethod("PUT");
           badMessagedto.setStatus(false);

           return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }
    
}
