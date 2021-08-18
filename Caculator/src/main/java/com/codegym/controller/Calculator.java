package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Calculator {
    public static final String ADDITION = "Addition(+)";
    public static final String SUBTRACTION = "Subtraction(-)";
    public static final String MULTIPLICATION = "Multiplication(X)";
    public static final String DIVISION = "Division(/)";

    @GetMapping(value = "")
    public ModelAndView show() {
        return new ModelAndView("show");
    }

    @PostMapping(value = "/cal")
    public ModelAndView calculator(@RequestParam(name = "num1", required = false) String num1,
                                   @RequestParam(name = "num2", required = false) String num2,
                                   @RequestParam(name = "cal") String cal) {
        if (num1 == "" || num2 == "") {
            return new ModelAndView("show", "message", "Input is required");
        } else {
            if (!isNumeric(num1) || !isNumeric(num2)) {
                return new ModelAndView("show", "message", "Invalid Value");
            } else {
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                int result;
                switch (cal) {
                    case ADDITION:
                        result = n1 + n2;
                        break;
                    case SUBTRACTION:
                        result = n1 - n2;
                        break;
                    case MULTIPLICATION:
                        result = n1 * n2;
                        break;
                    case DIVISION:
                        if (n2 == 0) {
//                    throw new RuntimeException("Can not divide by 0");
                            return new ModelAndView("show", "message", "Can not divide by 0");
                        } else {
                            result = n1 / n2;
                        }
                        break;
                    default:
                        throw new RuntimeException("Unsupported operation");
                }
                return new ModelAndView("show", "cal", result);
            }
        }


    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
