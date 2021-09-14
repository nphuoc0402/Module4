//package com.codegym.cms.model;
//
//import javax.persistence.*;
//import javax.validation.constraints.Digits;
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "withdraws")
//public class Withdraw {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id",referencedColumnName = "id")
//    private Customer customer;
//
//    @Digits(integer = 9, fraction = 0)
//    @Column(name = "transaction_amount")
//    private BigDecimal transactionAmount;
//
//    public Withdraw() {
//    }
//
//    public Withdraw(Long id, Customer customer, @Digits(integer = 9, fraction = 0) BigDecimal transactionAmount) {
//        this.id = id;
//        this.customer = customer;
//        this.transactionAmount = transactionAmount;
//    }
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
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
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public BigDecimal getTransactionAmount() {
//        return transactionAmount;
//    }
//
//    public void setTransactionAmount(BigDecimal transactionAmount) {
//        this.transactionAmount = transactionAmount;
//    }
//}
