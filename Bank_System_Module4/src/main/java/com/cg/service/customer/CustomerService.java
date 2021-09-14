package com.cg.service.customer;

import com.cg.dto.*;
import com.cg.model.Customer;
import com.cg.repository.ICustomerRepository;
import com.cg.repository.IDepositRepository;
import com.cg.repository.ITransferRepository;
import com.cg.repository.IWithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IDepositRepository depositRepository;

    @Autowired
    private IWithdrawRepository withdrawRepository;

    @Autowired
    private ITransferRepository transferRepository;

    @Override
    public Boolean existByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Iterable<Customer> findAllByDeletedIsFalse() {
        return customerRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<DepositDTO> findByIdWithDepositDTO(Long id) {
        return customerRepository.findByIdWithDepositDTO(id);
    }

    @Override
    public Optional<WithdrawDTO> findByIdWithWithdrawDTO(Long id) {
        return customerRepository.findByIdWithWithdrawDTO(id);
    }

    @Override
    public Iterable<RecipientDTO> findAllRecipientDTOByIdWithOutSender(Long id) {
        return customerRepository.findAllRecipientDTOByIdWithoutSender(id);
    }

    @Override
    public Iterable<RecipientDTO> findAllRecipientDTOByIdWithOutSenderAndDeletedIsFalse(Long id) {
        return customerRepository.findAllRecipientDTOByIdWithoutSenderAndDeletedIsFalse(id);
    }

    @Override
    public void doDeposit( DepositDTO depositDTO) {
        Optional<Customer> customer = customerRepository.findById(depositDTO.getCustomerId());

        customerRepository.incrementBalance(depositDTO.getTransactionAmount(),depositDTO.getCustomerId());

        depositRepository.save(depositDTO.toDeposit(customer));
    }

    @Override
    public void doWithdraw(WithdrawDTO withdrawDTO) {

        Optional<Customer> customer = customerRepository.findById(withdrawDTO.getCustomerId());

        customerRepository.decreaseBalance(withdrawDTO.getTransactionAmount(),withdrawDTO.getCustomerId());

        withdrawRepository.save(withdrawDTO.toWithdraw(customer));

    }

    @Override
    public void doTransfer(TransferDTO transferDTO,Optional<Customer> sender, Optional<Customer> recipient) {
        customerRepository.decreaseBalance(transferDTO.getTransactionAmount(),transferDTO.getSenderId());

        customerRepository.incrementBalance(transferDTO.getTransferAmount(),transferDTO.getRecipientId());

        transferRepository.save(transferDTO.toTransfer(sender,recipient));
    }

    @Override
    public void incrementBalance(BigDecimal balance, Long id) {
        customerRepository.incrementBalance(balance,id);
    }

    @Override
    public void decreaseBalance(BigDecimal balance, Long id) {
        customerRepository.decreaseBalance(balance,id);
    }


}
