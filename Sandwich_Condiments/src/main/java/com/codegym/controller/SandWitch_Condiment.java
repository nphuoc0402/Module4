package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class SandWitch_Condiment {
    @GetMapping("")
    public ModelAndView show(){
        return new ModelAndView("form");
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView result(@RequestParam (name="condiment", required = false) String[] condiment){
        if(!Objects.equals(condiment,null)){
            assert condiment != null;
            return new ModelAndView("recipe","condiment",condiment);
        }else {
            return new ModelAndView("form","message","Please at least 1 recipe!");
        }
    }

}
