package com.codegym.cms.service.customer;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAllActiveUsersNative();
    }

    @Override
    public Optional<Customer> findById(Long id) {

//        return customerRepository.findByIdNativeQuery(id);
        return customerRepository.findById(id);
    }

    @Override
    public void increment(int salary, Long id) {
        customerRepository.increment(salary,id);
    }

    @Override
    public void decrease(int salary, Long id) {
        customerRepository.decrease(salary,id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deposit(int salary, Long id) {
        customerRepository.deposit(salary,id);
    }

    @Override
    public void withdraw(int salary, Long id) {
        customerRepository.withdraw(salary,id);
    }

    @Override
    public void transfer(int salary, int fee, Long id) {
        customerRepository.transfer(salary,fee,id);
    }
}
