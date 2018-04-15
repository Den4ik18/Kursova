package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
