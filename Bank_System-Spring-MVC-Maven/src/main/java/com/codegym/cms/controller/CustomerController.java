package com.codegym.cms.controller;

import com.codegym.cms.DTO.TransferDTO;
import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Transfer;

import com.codegym.cms.repository.ITransferRepository;
import com.codegym.cms.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITransferRepository transferRepository;


    @GetMapping("/create-customer")
    public ModelAndView showCreate(){
        return new ModelAndView("/customer/create","customer",new Customer());
    }

    @PostMapping("/create-customer")
    public ModelAndView create(@Validated @ModelAttribute ("customer") Customer customer, BindingResult bindingResult){
//        new Customer().validate(customer,bindingResult);
        try {
            if (customer == null || bindingResult.hasFieldErrors()) {
                return new ModelAndView("/customer/create", "error", "New customer created fail");
            } else {
                customerService.save(customer);
                ModelAndView modelAndView = new ModelAndView("/customer/create");
                modelAndView.addObject("customer",new Customer());
                modelAndView.addObject("success", "New customer created successfully");
                return modelAndView;
            }
        }catch (Exception e){
            return new ModelAndView("/error.404");
        }
    }


    //change
    @GetMapping("/customers")
    public ModelAndView listCustomers() {
        return new ModelAndView("/customer/list","customers",customerService.findAll());
    }

    //change
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer.get());
            return new ModelAndView("/customer/edit","customer", customer.get());
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer/{id}")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer,@PathVariable Long id) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("success", "Customer updated successfully");
        return modelAndView;
    }

    //change
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            return new ModelAndView("/customer/delete","customer", customer.get());
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer) {
        try{
            customerService.remove(customer.getId());
            return new ModelAndView("redirect:customers") ;
        }catch (Exception e){
            return new ModelAndView("/error.404");
        }

    }

    @GetMapping("/deposit-customer/{id}")
    public ModelAndView showDeposit(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()){
            return new ModelAndView("/customer/deposit","customer", customer.get());
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/deposit-customer/{id}")
    public ModelAndView deposit(@ModelAttribute("customer") Customer customer,@PathVariable Long id){
        customerService.deposit(customer.getSalary(),customer.getId());
        ModelAndView modelAndView = new ModelAndView("/customer/deposit","customer",customerService.findById(id));
        return modelAndView;
    }

    @GetMapping("/withdraw-customer/{id}")
    public ModelAndView showWithdraw(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()){
            return new ModelAndView("/customer/withdraw","customer", customer.get());
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/withdraw-customer/{id}")
    public ModelAndView withdraw(@ModelAttribute("customer") Customer customer,@PathVariable Long id){
        customerService.withdraw(customer.getSalary(),customer.getId());
        ModelAndView modelAndView = new ModelAndView("/customer/deposit","customer",customerService.findById(id));
        return modelAndView;
    }

    @GetMapping("/transfer-customer/{id}")
    public ModelAndView showTransfer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/transfers/transfer");
            modelAndView.addObject("customer", customer.get());
            modelAndView.addObject("transfer",new Transfer());
            modelAndView.addObject("idSender",id);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/transfer-customer/{id}")
    public ModelAndView transfer(@ModelAttribute("transfer") Transfer transfer,@PathVariable (name = "id") Long id){
        transfer.setIdSender(id);
        ModelAndView modelAndView = new ModelAndView("/transfers/transfer");
        try{
            int fee_transaction = transfer.getAmount() + (transfer.getAmount() * transfer.getTransaction_fee() /100);
            transferRepository.save(transfer);
            customerService.increment(transfer.getAmount(),transfer.getIdReceiver());
            customerService.decrease(fee_transaction,id);
            TransferDTO transferDTO = new TransferDTO(id,customerService.findById(id).get().getName(),
                    transfer.getIdReceiver(),customerService.findById(transfer.getIdReceiver()).get().getName(),
                    transfer.getAmount(),transfer.getTransaction_fee(),transfer.getTotal_amount());
            modelAndView.addObject("transfer",transferDTO);
        modelAndView.addObject("success", "New customer created successfully");
            return modelAndView;
        }catch (IllegalStateException e){
            modelAndView.addObject("error", "Transfer Fail");
            return modelAndView;

        }
    }

//    @GetMapping("/transfer-history")
//    public ModelAndView showHistory(){
//        List<TransferDTO> list = transferRepository.listHistory();
//        return  new ModelAndView("/transfers/list","transfers",list);
//
//    }


}
