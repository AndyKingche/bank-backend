package com.bank.accountapp.messages;

import lombok.Data;

@Data
public class MessagesDTO {
    private String message;
    private String method;
    private boolean status;
}
