package com.codegym.cms.service.customer;

import com.codegym.cms.model.Customer;
import com.codegym.cms.service.IGeneralService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


public interface ICustomerService extends IGeneralService<Customer> {
    public void deposit(int salary,Long id);
    public void withdraw(int salary,Long id);
    public void transfer(int salary, int fee, Long id);
}
