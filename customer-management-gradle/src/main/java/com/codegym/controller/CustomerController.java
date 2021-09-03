package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public ModelAndView index() {
        List<Customer> customerList = customerService.findAll();
        return new ModelAndView("/index","customers", customerList);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create","customer", new Customer());
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        return new ModelAndView("/edit","customer", customerService.findById(id));
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id, Model model) {
        return new ModelAndView("/delete","customer", customerService.findById(id));

    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id, Model model) {
        return new ModelAndView("/view","customer", customerService.findById(id));
    }
}