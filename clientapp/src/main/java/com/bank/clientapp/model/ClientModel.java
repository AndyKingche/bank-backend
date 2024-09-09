package com.bank.clientapp.model;

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
@Table(name = "b_cli_client")
@NamedQuery(name = "ClientModel", query = "SELECT b_cli_client FROM ClientModel b_cli_client")
@Data
public class ClientModel implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personid")
    private PersonModel personid;

    @Column(name = "passwordclient")
    private String password;

    @Column(name = "status")
    private Boolean status;

}
