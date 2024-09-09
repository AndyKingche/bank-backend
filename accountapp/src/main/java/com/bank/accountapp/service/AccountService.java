package com.bank.accountapp.service;
import java.util.*;

import com.bank.accountapp.DTO.AccountDTO;
import com.bank.accountapp.model.AccountModel;

public interface AccountService {

    List<AccountModel> listAccount();
    Optional<AccountModel> accountId(Long id);
    AccountModel createAccount(AccountModel account);
    Optional<AccountModel> updateAccount(Long id, AccountModel account);
    boolean deleteAccount(Long id);
    
}
