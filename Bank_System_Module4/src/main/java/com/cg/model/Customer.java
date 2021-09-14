package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table  (name = "customers")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},targetEntity = Deposit.class)
    private List<Deposit> depositList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},targetEntity = Withdraw.class)
    private List<Withdraw> withdrawList;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "customerSend", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},targetEntity = Transfer.class)
    private Transfer transferS;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "customerRec", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},targetEntity = Transfer.class)
    private Transfer transferR;

    private String fullName;

    @NotEmpty(message = "The mail address is required.")
    @Email(message = "The email adddresss is invalid.")
    @Size(min = 5,max = 50,message = "The length of email must be between 5 to 50 characters.")
    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
    private String address;

    @Digits(integer = 9, fraction = 0)
    @Column(updatable = false)
    private BigDecimal balance;

}
