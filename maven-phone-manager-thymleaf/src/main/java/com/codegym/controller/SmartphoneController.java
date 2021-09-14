package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        Iterable<Smartphone> smartphones = smartphoneService.findAll();
        if(((List) smartphones).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Smartphone> getId(@PathVariable Long id){
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if(smartphone.isPresent()){
            return new ResponseEntity<>(smartphone.get(),HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmartPhone(@PathVariable Long id, @RequestBody Smartphone smartphone){
        Optional<Smartphone> optionalSmartphone = smartphoneService.findById(id);
        if(!optionalSmartphone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(optionalSmartphone.get().getId());
        return new ResponseEntity<>(smartphoneService.save(smartphone),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping()
    public ResponseEntity<Smartphone> deleteCustomer(@RequestBody Map<String, String> json) {
        Long id = Long.valueOf(json.get("id"));
        Optional<Smartphone> customerOptional = smartphoneService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }


}