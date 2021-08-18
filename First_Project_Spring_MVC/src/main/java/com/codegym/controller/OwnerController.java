package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/owner/{ownerId}")
public class OwnerController {
    @GetMapping("/pets/{petId}")
    public String findPet(@PathVariable Long ownerId, @PathVariable Long petId) {
        return "index";
    }

    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    public String handle(@PathVariable String name, @PathVariable String version, @PathVariable String ext){
        return "index";
    }
}
