package com.codegym.cms.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView exception(NullPointerException e){
        ModelAndView modelAndView = new ModelAndView("/error1");
        return modelAndView;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView exception2(IllegalArgumentException e){
        ModelAndView modelAndView = new ModelAndView("/error2");
        return modelAndView;
    }
}
