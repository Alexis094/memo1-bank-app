package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountCbu;
    private Double amount = 0.0;
    private String transactionType;

    public Transaction(){
    }

    public Transaction(Long accountCbu, Double amount, String transactionType){
        this.amount = amount;
        this.accountCbu = accountCbu;
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getAccountCbu(){
        return this.accountCbu;
    }

    public Long getId(){
        return this.id;
    }

    public String getTransactionType(){
        return this.transactionType;
    }
}