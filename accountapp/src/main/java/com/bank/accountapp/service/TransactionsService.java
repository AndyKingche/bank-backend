package com.bank.accountapp.service;
import java.time.LocalDate;
import java.util.*;

import com.bank.accountapp.DTO.ReportDTO;
import com.bank.accountapp.DTO.TransactionsDTO;
import com.bank.accountapp.model.TransactionsModel;


public interface TransactionsService {

    List<TransactionsModel> listTransactions();
    Optional<TransactionsModel> transactionsId(Long id);
    TransactionsModel createTransactions(TransactionsDTO transactionsDTO);
    TransactionsModel doTransactions(TransactionsDTO transactionsDTO);
    Optional<TransactionsModel> updateTransactions(Long id, TransactionsDTO transactionsDTO);
    boolean deleteTransactions(Long id);
    ReportDTO reportTransactions(LocalDate fechaInicio, LocalDate fechaFin, Integer clientId );
}
