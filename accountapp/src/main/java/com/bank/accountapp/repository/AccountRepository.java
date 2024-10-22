package com.bank.accountapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.accountapp.model.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {

    List<AccountModel> findByPersonid(Integer personid);

    Optional<AccountModel> findByNumberaccount(String numberaccount);

}
