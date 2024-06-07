package com.example.springpagindation.controller;

import com.example.springpagindation.req.CustomerReq;
import com.example.springpagindation.resp.CustomerRes;
import com.example.springpagindation.service.CustomerService;
import com.example.springpagindation.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customer/v1/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerRes> addCustomer(@RequestBody CustomerReq customerReq){
        if(customerService.saveCustomer(customerReq)){
            return ResponseEntity.ok().body(new CustomerRes("Customer Created"));
        }
        return ResponseEntity.ok().body(new CustomerRes("Error Creating Customer"));
    }

    @GetMapping("/customer/v1/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Page<Customer> getAll(@RequestParam int page, @RequestParam int size){
      return customerService.getAll(page,size);
    }

    @GetMapping("/customer/v1/customers/getall")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
