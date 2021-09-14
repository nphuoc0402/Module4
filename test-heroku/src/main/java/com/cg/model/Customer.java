package com.cg.model;

import com.cg.model.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Accessors(chain = true)
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    @Digits(integer = 12, fraction = 0)
    @Column(updatable = false)
    private BigDecimal balance;


    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private LocationRegion locationRegion;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Deposit> deposits;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Withdraw> withdraws;

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Transfer> sender;

    @OneToMany(mappedBy = "recipient", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Transfer> recipient;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", address=" + locationRegion +
                ", deposits=" + deposits +
                ", withdraws=" + withdraws +
                ", sender=" + sender +
                ", recipient=" + recipient +
                '}';
    }

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setLocationRegion(locationRegion.toLocationRegionDTO())
                .setBalance(balance);
    }
}
