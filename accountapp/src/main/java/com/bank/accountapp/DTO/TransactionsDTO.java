package com.bank.accountapp.DTO;


import lombok.Data;

@Data
public class TransactionsDTO {

    private Integer id;
    private Integer account;
    private String typetransfer;
    private Float valuetransfer;
    private Float balance;
    
}
