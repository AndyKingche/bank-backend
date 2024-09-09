package com.bank.accountapp.DTO;

import java.util.List;

import com.bank.accountapp.model.AccountModel;
import com.bank.accountapp.model.TransactionsModel;

import lombok.Data;

@Data
public class ReportDTO {

    private List<AccountModel> account;
    private List<TransactionsModel> transactions;

}
