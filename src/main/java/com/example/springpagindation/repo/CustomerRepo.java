package com.example.springpagindation.repo;

import com.example.springpagindation.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Override
    Page<Customer> findAll(Pageable pageable);
}
