package com.bank.accountapp.DTO;

import lombok.Data;

@Data
public class AccountDTO {

    private Integer id;
    private String numberaccount;
    private String typeaccount;
    private Float balance;
    private Integer personid;
    private boolean status;
}
