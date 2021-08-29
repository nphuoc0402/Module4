package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Transfer;
import com.codegym.cms.repository.ITransferRepository;
import com.codegym.cms.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/create")
    public ModelAndView create(@Validated  @ModelAttribute ("customer") Customer customer, BindingResult bindingResult){
        if(customer == null || bindingResult.hasFieldErrors()){
            return  new ModelAndView("/customer/create","error","New customer created fail");
        }else{
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("success", "New customer created successfully");

            return modelAndView;
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

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("success", "Customer updated successfully");
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
        customerService.remove(customer.getId());
        return new ModelAndView("redirect:customers") ;
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

    @PostMapping("/deposit")
    public ModelAndView deposit(@ModelAttribute("customer") Customer customer){
        customerService.deposit(customer.getSalary(),customer.getId());
        ModelAndView modelAndView = new ModelAndView("/customer/deposit");
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

    @PostMapping("/withdraw")
    public ModelAndView withdraw(@ModelAttribute("customer") Customer customer){
        customerService.withdraw(customer.getSalary(),customer.getId());
        ModelAndView modelAndView = new ModelAndView("/customer/deposit");
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

    @PostMapping("/transfer")
    public ModelAndView transfer(@ModelAttribute("transfer") Transfer transfer){
//         customerService.transfer(transfer.getAmount(),transfer.getTransaction_fee()*transfer.getAmount()/100,transfer.getIdSender());
//         customerService.deposit(transfer.getAmount(),transfer.getIdReceiver());
         transferRepository.save(transfer);
        ModelAndView modelAndView = new ModelAndView("/customer/transfer");
//        modelAndView.addObject("success", "New customer created successfully");
        return modelAndView;
    }


}
