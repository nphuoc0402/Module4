package com.codegym.controller;

import com.codegym.model.MailBox;
import com.codegym.service.FormBindingMailService;
import com.codegym.service.IFormBindingMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.AssertTrue;

@Controller
@RequestMapping("/mailbox")
public class MailController {

    @Autowired
    private IFormBindingMail formBindingMaiServicel;

    @GetMapping
    public ModelAndView showMailBox(){
        ModelAndView modelAndView =  new ModelAndView("/home");
        modelAndView.addObject("mailbox",new MailBox());
        modelAndView.addObject("lang",new String[]{"Enlish","Vienamese","Japanese","Chinese"});
        modelAndView.addObject("pagesize",new int[]{5,10,15,25,50,100});
        modelAndView.addObject("check",new boolean[]{true,false});
        return modelAndView;
    }

    @PostMapping
    public ModelAndView update(@ModelAttribute("mailbox") MailBox mailBox){
        ModelAndView modelAndView =  new ModelAndView("/home");
        formBindingMaiServicel.save(mailBox);
        modelAndView.addObject("lang",new String[]{"Enlish","Vienamese","Japanese","Chinese"});
        modelAndView.addObject("pagesize",new int[]{5,10,15,25,50,100});
        modelAndView.addObject("check",new boolean[]{true,false});
        return modelAndView;
    }



}
