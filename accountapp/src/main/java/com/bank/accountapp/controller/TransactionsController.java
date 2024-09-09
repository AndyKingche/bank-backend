package com.bank.accountapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountapp.DTO.TransactionsDTO;
import com.bank.accountapp.messages.MessagesDTO;
import com.bank.accountapp.model.TransactionsModel;
import com.bank.accountapp.service.TransactionsService;

@RestController
@RequestMapping("api/movimientos/")
@CrossOrigin
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    

     @GetMapping("list-transfer")
     public ResponseEntity<List<TransactionsModel>> getAllListTransactions(){
        try {
            List<TransactionsModel> result = transactionsService.listTransactions();

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
        
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
     }

     @GetMapping("transfer/{id}")
     public ResponseEntity<?> getTransferId(@PathVariable("id") Long id){
         
         try {
             
             Optional<TransactionsModel> result = transactionsService.transactionsId(id);
        

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

     @PostMapping("create-transfer")
     public ResponseEntity<MessagesDTO> createTransfer(@RequestBody TransactionsDTO transfer){
 
        try {
            
          
           TransactionsModel createdTransfer = transactionsService.createTransactions(transfer);
 
            MessagesDTO menssagedto = new MessagesDTO();
 
            menssagedto.setMessage("Transactions created with ID "+ createdTransfer.getId());
            menssagedto.setMethod("POST");
            menssagedto.setStatus(true);
 
            return new ResponseEntity<>(menssagedto, HttpStatus.CREATED);
            
        } catch(IllegalArgumentException e){
 
            MessagesDTO badMessagedto = new MessagesDTO();
 
            badMessagedto.setMessage("Invalid input: " + e.getMessage());
            badMessagedto.setMethod("POST");
            badMessagedto.setStatus(false);
 
            return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        catch (Exception e) {
 
            MessagesDTO badMessagedto = new MessagesDTO();
 
            badMessagedto.setMessage("Error" + e.getMessage());
            badMessagedto.setMethod("POST");
            badMessagedto.setStatus(false);
 
            return new ResponseEntity<>(badMessagedto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
 
     }
 
     @PutMapping("transfer-edit/{id}")
     public ResponseEntity<MessagesDTO> updateTransfer(@PathVariable("id") Long id, @RequestBody TransactionsDTO transfer) {
 
        try {
            
            Optional<TransactionsModel> updatedTransfer = transactionsService.updateTransactions(id, transfer);
 
             MessagesDTO menssagedto = new MessagesDTO();
 
             menssagedto.setMessage("Transfer updated with ID "+ updatedTransfer.get().getId());
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


     @DeleteMapping("transfer-delete/{id}")
     public ResponseEntity<MessagesDTO> deletePerson(@PathVariable("id") Long id){
        try {
            
            transactionsService.deleteTransactions(id);
            
            MessagesDTO menssagedto = new MessagesDTO();
 
             menssagedto.setMessage("Transfer delete with ID "+ id);
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
