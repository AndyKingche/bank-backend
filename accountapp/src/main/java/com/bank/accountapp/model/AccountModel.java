package com.bank.accountapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "b_acc_account")
@NamedQuery(name = "AccountModel.findAll", query = "SELECT b_acc_account FROM AccountModel b_acc_account")
@Data
public class AccountModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountid")
    private Long id;
    
    @Column(name = "numberaccount")
    private String numberaccount;

    @Column(name = "typeaccount")
    private String typeaccount;

    @Column(name = "openingbalance")
    private Float balance;

    @Column(name = "personid")
    private Integer personid;

    @Column(name = "status")
    private Boolean status;
    

}
