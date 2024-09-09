package com.bank.accountapp.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.accountapp.DTO.TransactionsDTO;
import com.bank.accountapp.mapper.TransactionsMapper;
import com.bank.accountapp.model.AccountModel;
import com.bank.accountapp.model.TransactionsModel;
import com.bank.accountapp.repository.TransactionsRepository;
import com.bank.accountapp.service.AccountService;
import com.bank.accountapp.service.TransactionsService;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<TransactionsModel> listTransactions() {
        return transactionsRepository.findAll();
    }

    @Override
    public Optional<TransactionsModel> transactionsId(Long id) {

           return transactionsRepository.findById(id).map(transactionFound ->{

            return Optional.of(transactionFound);
        }).orElseThrow(()-> new EntityNotFoundException("Transaction not found with ID: " + id));
    }

    @Override
    public TransactionsModel createTransactions(TransactionsDTO transactionsDTO) {
        try {

            TransactionsModel transfer = TransactionsMapper.INSTANCE.transactionsDTOToTransactionsModel(transactionsDTO);
    
            Optional<AccountModel> accountExists = accountService.accountId(transfer.getAccount().getId());
    
            if(accountExists.isPresent()){
    
                return transactionsRepository.save(transfer);
            }
            else{
    
                throw new IllegalArgumentException("The account with the id does not exist : " + transfer.getAccount().getId());
            }
    
           }
           catch (Exception e) {
            throw new RuntimeException("Error processing create transactions request: "+ e);
           }
    }

    @Override
    public Optional<TransactionsModel> updateTransactions(Long id, TransactionsDTO transactionsDTO) {

        TransactionsModel createdTransactions = TransactionsMapper.INSTANCE.transactionsDTOToTransactionsModel(transactionsDTO);

        return transactionsId(id).map(transerFound -> {
           
            if(transactionsDTO.getAccount() != null){

                long accountId = transactionsDTO.getAccount();

                Optional<AccountModel> accountExists = accountService.accountId(accountId);

                if(accountExists.isPresent()){
                    
                    if(createdTransactions.getBalance()!= null){
                        transerFound.setBalance(createdTransactions.getBalance());
                    }
                    if(createdTransactions.getTypetransfer()!=null){
                        transerFound.setTypetransfer(createdTransactions.getTypetransfer());
                    }
                    if(createdTransactions.getValuetransfer() != null){
                        transerFound.setValuetransfer(createdTransactions.getValuetransfer());
                    }
                    if(createdTransactions.getAccount().getId() != null){
                        transerFound.setAccount(createdTransactions.getAccount());
                    }
                  
                    transactionsRepository.save(transerFound);
    
                }
            }


            return Optional.of(transerFound);
            

        }).orElseThrow(() -> new EntityNotFoundException("Transactions not found with ID: " + id));
    }

    @Override
    public boolean deleteTransactions(Long id) {

        return transactionsId(id).map(transfer -> {
            transactionsRepository.delete(transfer);
            return true;
        }).orElseThrow(() -> new EntityNotFoundException("Transactions not found with ID: " + id));

    }

}
