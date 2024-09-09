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

import com.bank.accountapp.messages.MessagesDTO;
import com.bank.accountapp.model.AccountModel;
import com.bank.accountapp.service.AccountService;

@RestController
@RequestMapping("api/cuentas/")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

     @GetMapping("list-account")
     public ResponseEntity<List<AccountModel>> getAllListAccount(){
        try {
            List<AccountModel> result = accountService.listAccount();

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
        
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
     }

     @GetMapping("account/{id}")
     public ResponseEntity<?> getAccountId(@PathVariable("id") Long id){
         
         try {
             
             Optional<AccountModel> result = accountService.accountId(id);
        

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

     @PostMapping("create-account")
     public ResponseEntity<MessagesDTO> createAccount(@RequestBody AccountModel accountModel){

        try {
            
           AccountModel createdAccount = accountService.createAccount(accountModel);

            MessagesDTO menssagedto = new MessagesDTO();

            menssagedto.setMessage("Account created with ID "+ createdAccount.getId());
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

     @PutMapping("account-edit/{id}")
     public ResponseEntity<MessagesDTO> updateAccount(@PathVariable("id") Long id, @RequestBody AccountModel accountModel) {

        try {
            
            Optional<AccountModel> updatedAccount = accountService.updateAccount(id, accountModel);

             MessagesDTO menssagedto = new MessagesDTO();
 
             menssagedto.setMessage("Account updated with ID "+ updatedAccount.get().getId());
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

     @DeleteMapping("account-delete/{id}")
     public ResponseEntity<MessagesDTO> deleteAccount(@PathVariable("id") Long id){
        try {
            
            
            accountService.deleteAccount(id);

            
            MessagesDTO menssagedto = new MessagesDTO();
 
             menssagedto.setMessage("Account delete with ID "+ id);
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
