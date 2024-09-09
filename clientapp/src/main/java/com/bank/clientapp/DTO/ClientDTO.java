package com.bank.clientapp.DTO;

import lombok.Data;

@Data
public class ClientDTO {

    private Integer id;
    private Integer personid;
    private String password;
    private boolean status;

}
