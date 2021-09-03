package com.codegym.cms.service.customer;

import com.codegym.cms.model.Customer;
import com.codegym.cms.service.IGeneralService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


public interface ICustomerService extends IGeneralService<Customer> {
    public void deposit(BigDecimal salary, Long id);
    public void withdraw(BigDecimal salary,Long id);
    public void transfer(BigDecimal salary, int fee, Long id);
    void increment(BigDecimal salary, Long id);
    void decrease(BigDecimal salary, Long id);
    Iterable<Customer> findAllWithoutSenderById(Long id);
}
