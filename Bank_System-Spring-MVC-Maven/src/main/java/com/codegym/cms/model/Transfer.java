package com.codegym.cms.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idSender")
    private Long idSender;
    @Column(name = "idReceiver")
    private Long idReceiver;
    @Column(name = "amount" )
    private BigDecimal amount;
    @Column(name = "fee_percent")
    private BigDecimal transaction_fee = new BigDecimal("5");
    @Column(name = "total_amount")
    private BigDecimal total_amount;

    public Transfer() {
    }

    public Transfer(Long idReceiver, BigDecimal amount, BigDecimal transaction_fee, BigDecimal total_amount) {
        this.idReceiver = idReceiver;
        this.amount = amount;
        this.transaction_fee = transaction_fee;
        this.total_amount = total_amount;
    }

    public Transfer(Long id, Long idSender, Long idReceiver, BigDecimal amount, BigDecimal transaction_fee, BigDecimal total_amount) {
        this.id = id;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.amount = amount;
        this.transaction_fee = transaction_fee;
        this.total_amount = total_amount;
    }

    public Transfer(Long idSender, Long idReceiver, BigDecimal amount, BigDecimal transaction_fee, BigDecimal total_amount) {
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.amount = amount;
        this.transaction_fee = transaction_fee;
        this.total_amount = total_amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public Long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Long idReceiver) {
        this.idReceiver = idReceiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTransaction_fee() {
        return transaction_fee;
    }

    public void setTransaction_fee(BigDecimal transaction_fee) {
        this.transaction_fee = transaction_fee;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

}