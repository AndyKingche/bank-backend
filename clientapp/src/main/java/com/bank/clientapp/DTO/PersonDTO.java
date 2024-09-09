package com.bank.clientapp.DTO;

import lombok.Data;

@Data
public class PersonDTO {

    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
}
