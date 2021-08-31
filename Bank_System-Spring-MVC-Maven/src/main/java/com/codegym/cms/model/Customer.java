package com.codegym.cms.model;

import com.codegym.cms.handler.CustomExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNullFields;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Đặt tên
@Entity
@Table(name = "customers")
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    @NotEmpty(message="Name is required")
    private String name;

    @Column(name = "c_phone")
    @NotEmpty(message="Phone is required")
    private String phone;

    @Column(name = "c_email")
    @NotEmpty(message="Email is required")
    private String email;

    @Column(name = "c_salary")
    private int salary = 0;

    public Customer() {
    }

    public Customer(Long id, String name, String phone, String email, int salary) {
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

//    @Override
//    public boolean supports(Class<?> aClass) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Customer customer = (Customer) o;
//        String name = customer.getName();
//        if(name == "" || "".equalsIgnoreCase(name)){
//            errors.rejectValue("name","error.name.blank","Name is not empty");
//        }
//        String phone = customer.getPhone();
//
//    }
}
