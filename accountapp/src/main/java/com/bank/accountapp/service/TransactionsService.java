package com.bank.accountapp.service;
import java.util.*;

import com.bank.accountapp.DTO.TransactionsDTO;
import com.bank.accountapp.model.TransactionsModel;


public interface TransactionsService {

    List<TransactionsModel> listTransactions();
    Optional<TransactionsModel> transactionsId(Long id);
    TransactionsModel createTransactions(TransactionsDTO transactionsDTO);
    Optional<TransactionsModel> updateTransactions(Long id, TransactionsDTO transactionsDTO);
    boolean deleteTransactions(Long id);
}
