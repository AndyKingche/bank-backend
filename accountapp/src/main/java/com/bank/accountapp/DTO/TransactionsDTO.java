package com.bank.accountapp.DTO;


import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class TransactionsDTO {

    private Integer id;
    private Integer account;
    private String typetransfer;
    private Float valuetransfer;
    private Float balance;
    private LocalDate datetransfer;
    
}
