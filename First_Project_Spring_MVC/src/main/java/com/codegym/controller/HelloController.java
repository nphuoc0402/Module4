package com.codegym.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "home")
public class HelloController {
    @RequestMapping(value = "/car?/s?o?/infor1")
    public String  infor1(Model model){
        model.addAttribute("name","Infor1");
        return "index";
    }

    @RequestMapping (value = "/c*/s*d/info*")
    public String infor2(Model model){
        model.addAttribute("name","Infor2");
        return "index";
    }

    @RequestMapping(value = "/card/**")
    public String infor3(Model model){
        model.addAttribute("name","Infor3");
        return "index";
    }

    @RequestMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String infor4(Model model){
        model.addAttribute("name","Infor4");
        return "index";
    }

    @RequestMapping(value = "hello",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping(value = "hello1")
    public String hello1(){
        return "";
    }
}
