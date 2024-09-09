package com.bank.accountapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.accountapp.model.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {

    

}
