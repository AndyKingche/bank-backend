package com.bank.accountapp.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClientFeignClient {

    @GetMapping("api/clientapp/client/{id}")
    Boolean clientExists(@PathVariable("id") Integer personId);
}
