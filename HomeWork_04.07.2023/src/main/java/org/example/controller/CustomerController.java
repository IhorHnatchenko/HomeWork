package org.example.controller;

import org.example.model.Customer;
import org.example.model.Product;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable (name = "id") int id){
        return customerService.getById(id);
    }

    @PostMapping("/save")
    public Customer create(@RequestBody Customer customer){
        return customerService.createNew(customer);
    }

    @PostMapping("/save/basket/{id}")
    public List<Product> addToBasket(@PathVariable (name = "id") int id, @RequestBody Product product){
        return  customerService.saveInBasket(id, product);
    }
}
