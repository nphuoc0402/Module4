package com.codegym.cms.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @Column(name = "c_phone")
    @NotEmpty
    private String phone;

    @Column(name = "c_email")
    @NotEmpty
    private String email;

    @Column(name = "c_salary")
    private int salary = 0;

    public Customer() {
    }

    public Customer(@NotEmpty Long id,  @Size(min = 2, max = 30)String name, String phone, String email, int salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }

    public Customer(@Size(min = 2, max = 30)String name, String phone, String email, int salary) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
