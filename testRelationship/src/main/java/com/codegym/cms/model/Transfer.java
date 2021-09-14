//package com.codegym.cms.model;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "transfers")
//public class Transfer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "idSender",referencedColumnName = "id")
//    private Customer customerSender;
//
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "idReceiver",referencedColumnName = "id")
//    private Customer customerReceiver;
//
//
//    @Column(name = "amount" )
//    private BigDecimal amount;
//
//
//    @Column(name = "fee_percent")
//    private BigDecimal transaction_fee = new BigDecimal("5");
//
//
//    @Column(name = "total_amount")
//    private BigDecimal total_amount;
//
//    public Transfer() {
//    }
//
//    public Transfer(Long id, Customer customerSender, Customer customerReceiver, BigDecimal amount, BigDecimal transaction_fee, BigDecimal total_amount) {
//        this.id = id;
//        this.customerSender = customerSender;
//        this.customerReceiver = customerReceiver;
//        this.amount = amount;
//        this.transaction_fee = transaction_fee;
//        this.total_amount = total_amount;
//    }
//
//    public Transfer(Customer customerSender, Customer customerReceiver, BigDecimal amount, BigDecimal transaction_fee, BigDecimal total_amount) {
//        this.customerSender = customerSender;
//        this.customerReceiver = customerReceiver;
//        this.amount = amount;
//        this.transaction_fee = transaction_fee;
//        this.total_amount = total_amount;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Customer getCustomerSender() {
//        return customerSender;
//    }
//
//    public void setCustomerSender(Customer customerSender) {
//        this.customerSender = customerSender;
//    }
//
//    public Customer getCustomerReceiver() {
//        return customerReceiver;
//    }
//
//    public void setCustomerReceiver(Customer customerReceiver) {
//        this.customerReceiver = customerReceiver;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigDecimal amount) {
//        this.amount = amount;
//    }
//
//    public BigDecimal getTransaction_fee() {
//        return transaction_fee;
//    }
//
//    public void setTransaction_fee(BigDecimal transaction_fee) {
//        this.transaction_fee = transaction_fee;
//    }
//
//    public BigDecimal getTotal_amount() {
//        return total_amount;
//    }
//
//    public void setTotal_amount(BigDecimal total_amount) {
//        this.total_amount = total_amount;
//    }
//}