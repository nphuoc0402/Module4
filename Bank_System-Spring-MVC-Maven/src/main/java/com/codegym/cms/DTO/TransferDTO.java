package com.codegym.cms.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TransferDTO {

    private Long id;
    private Long idSender;
    private String nameSender;
    private Long idReceiver;
    private String nameReceiver;
    private int amount;
    private int transaction_fee;
    private int total_amount;

    public TransferDTO() {
    }

    public TransferDTO(Long id, Long idSender, String nameSender, Long idReceiver, String nameReceiver, int amount, int transaction_fee, int total_amount) {
        this.id = id;
        this.idSender = idSender;
        this.nameSender = nameSender;
        this.idReceiver = idReceiver;
        this.nameReceiver = nameReceiver;
        this.amount = amount;
        this.transaction_fee = transaction_fee;
        this.total_amount = total_amount;
    }

    public TransferDTO(Long idSender, String nameSender, Long idReceiver, String nameReceiver, int amount, int transaction_fee, int total_amount) {
        this.idSender = idSender;
        this.nameSender = nameSender;
        this.idReceiver = idReceiver;
        this.nameReceiver = nameReceiver;
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

    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }

    public Long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Long idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTransaction_fee() {
        return transaction_fee;
    }

    public void setTransaction_fee(int transaction_fee) {
        this.transaction_fee = transaction_fee;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
}
