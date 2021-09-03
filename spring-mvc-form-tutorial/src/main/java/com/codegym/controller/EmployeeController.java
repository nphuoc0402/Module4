package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping(value = "/showform")
    public ModelAndView show(){
       return new ModelAndView("/create","employee",new Employee());
    }

    @PostMapping(value = "/addEmployee")
    public String add(Employee employee, ModelMap model){
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "/info";
    }

}
