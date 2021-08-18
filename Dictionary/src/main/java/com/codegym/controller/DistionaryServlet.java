package com.codegym.controller;

import com.codegym.service.Dictionary;
import com.codegym.service.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DistionaryServlet {
    @Autowired
    private IDictionary dictionary;
    @GetMapping("show")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("form");
        return modelAndView;
    }

    @PostMapping("translate")
    public ModelAndView translate(HttpServletRequest request){
        String name = request.getParameter("eng");
        String result = dictionary.search(name);
        ModelAndView modelAndView = new ModelAndView("translate");
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
