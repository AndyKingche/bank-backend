package com.bank.accountapp.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accountapp.DTO.AccountDTO;
import com.bank.accountapp.model.AccountModel;
import com.bank.accountapp.repository.AccountRepository;
import com.bank.accountapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountModel> listAccount() {

        return accountRepository.findAll();
    }

    @Override
    public Optional<AccountModel> accountId(Long id) {

        return accountRepository.findById(id).map(accountFound ->{

            return Optional.of(accountFound);
        }).orElseThrow(()-> new EntityNotFoundException("Account not found with ID: " + id));

    }

    @Override
    public AccountModel createAccount(AccountModel account) {
        try {
            
            return accountRepository.save(account);

        } catch (Exception e) {
            throw new RuntimeException("Error processing create account request: "+ e);
        }
    }

    @Override
    public Optional<AccountModel> updateAccount(Long id, AccountModel account) {
       
        return accountId(id).map(accountFound ->{
            accountFound.setNumberaccount(account.getNumberaccount());
            accountFound.setTypeaccount(account.getTypeaccount());
            accountFound.setBalance(account.getBalance());
            accountFound.setPersonid(account.getPersonid());
            accountFound.setStatus(account.getStatus());
            
            accountRepository.save(accountFound);

            return Optional.of(accountFound);

        }).orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + id));
    }

    @Override
    public boolean deleteAccount(Long id) {

        return accountId(id).map(account -> {
            accountRepository.delete(account);
            return true;
        }).orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + id));
    }

}
