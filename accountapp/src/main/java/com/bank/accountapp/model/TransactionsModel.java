package com.bank.accountapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "b_acc_transfer")
@NamedQuery(name = "TransactionsModel.findAll", query = "SELECT b_acc_transfer FROM TransactionsModel b_acc_transfer")
@Data
public class TransactionsModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transferid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accountid")
    private AccountModel account;

    @Column(name = "typetransfer")
    private String typetransfer;

    @Column(name = "valuetransfer")
    private Float valuetransfer;

    @Column(name = "balance")
    private Float balance;

}
