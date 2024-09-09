package com.bank.accountapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.accountapp.model.TransactionsModel;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsModel, Long>{

}
