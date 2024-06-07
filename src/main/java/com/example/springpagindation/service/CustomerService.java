package com.example.springpagindation.service;

import com.example.springpagindation.req.CustomerReq;
import com.example.springpagindation.model.Customer;
import com.example.springpagindation.repo.CustomerRepo;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public boolean saveCustomer(CustomerReq customer){
       try{
            Customer cust =  Customer.builder()
                    .customerAge(customer.getCustomerAge())
                    .customerName(customer.getCustomerName())
                    .build();
            customerRepo.save(cust);
           return true;
    }catch (Exception ex){
        ex.printStackTrace();
        return false;
    }
    }

    public Page<Customer> getAll(int page, int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<Customer> customers = this.customerRepo.findAll(pageRequest);
        return  customers;
    }

    public List<Customer> getAll(){
        List<Customer> customers = this.customerRepo.findAll();
        return  customers;
    }

}
