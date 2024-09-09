package com.bank.accountapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.accountapp.model.AccountModel;
import com.bank.accountapp.model.TransactionsModel;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsModel, Long>{


    List<TransactionsModel> findByAccountInAndDatetransferBetween(List<AccountModel> accounts, LocalDate startDate, LocalDate endDate);
}
