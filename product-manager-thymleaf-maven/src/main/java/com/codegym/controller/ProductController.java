package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();
    private static int  i = 0;
    @GetMapping("")
    public ModelAndView index() {
        List<Product> productList = productService.findAll();
        return new ModelAndView("/index","products", productList);
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/create","product",new Product());
    }

    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) (Math.random() * 100));
        productService.save(product);
        return "redirect:/products";
    }


    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        return new ModelAndView ("/edit","product",productService.findById(id));

    }

    @PostMapping("/update")
    public String update(Product prodcut){
        productService.update(prodcut.getId(),prodcut);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable int id){
        return new ModelAndView("/delete","product",productService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getId()) ;
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        return new ModelAndView("/view","product",productService.findById(id));

    }


}
