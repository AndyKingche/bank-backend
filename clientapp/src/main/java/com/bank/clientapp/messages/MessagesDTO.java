package com.bank.clientapp.messages;

import lombok.Data;

@Data
public class MessagesDTO {

    private String message;
    private String method;
    private boolean status;
}
