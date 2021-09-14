package com.codegym.cms.model;

import javax.persistence.*;

//Đặt tên
@Entity
@Table(name = "users")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Salary salary;

    public Employee() {
    }

    public Employee(Long id, Salary salary) {
        this.id = id;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
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
