package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.customer.ICustomerService;
import com.cg.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITransferService transferService;

    @GetMapping
    public ModelAndView listCustomer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/list");
        Iterable<Customer> customers = customerService.findAllByDeletedIsFalse();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
}
