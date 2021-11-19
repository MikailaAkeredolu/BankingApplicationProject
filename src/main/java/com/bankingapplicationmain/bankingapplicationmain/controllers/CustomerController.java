package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //get customer by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    //create customer
    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    //edit customer
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer){
        return customerService.updateCustomer(customer, id);
    }

    //Get customer that owns the specified account
    @GetMapping("/account/{customerId}/customer")
    public ResponseEntity<Object> getCustomerByAccount(@PathVariable Long customerId){
        return customerService.getCustomerByAccount(customerId);
    }


}