package com.bank.accountapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.bank.accountapp.DTO.TransactionsDTO;
import com.bank.accountapp.model.AccountModel;
import com.bank.accountapp.model.TransactionsModel;

@Mapper
public interface TransactionsMapper {

    TransactionsMapper INSTANCE = Mappers.getMapper(TransactionsMapper.class);

    @Mapping(source="account", target = "account", qualifiedByName = "accountToAccountId")
    TransactionsDTO transactionModelToTransactionsDTO(TransactionsModel transactionsModel);

    @Mapping(source = "account", target = "account", qualifiedByName = "accountIdToAccount")
    TransactionsModel transactionsDTOToTransactionsModel(TransactionsDTO transactionsDTO);

    @Named("accountToAccountId")
    default Long mapAccountToAccountId(AccountModel account){
        return account!= null ? account.getId() : null;
    }

    @Named("accountIdToAccount")
    default AccountModel mapAccountIdToAccount(Long id){
        if(id==null) return null;
        AccountModel account = new AccountModel();

        account.setId(id);
        return account;

    }
    
}
