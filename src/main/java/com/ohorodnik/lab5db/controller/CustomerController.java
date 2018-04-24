package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.Customer;
import com.ohorodnik.lab5db.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //@Autowired
    //CustomerServiceImpl organizationService;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/get")
    public List<Customer> getCustomer()  {
        //return organizationService.getCustomers();
        return customerRepository.findAll();
    }

    @PostMapping("/insert")
    public Customer insertCustomer(@RequestBody Customer customer){
        //return organizationService.insertCustomer(organization);
        return customerRepository.save(customer);
    }
    @RequestMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer,@RequestParam("id")int id)  {
        customer.setIdCustomer(id);
        return customerRepository.save(customer);
        //return organizationService.updateCustomer(organization);
    }

    @RequestMapping("/del")
    public void deleteCustomer(@RequestParam("id")int id)  {
        //organizationService.deleteCustomer(id);
        customerRepository.deleteById(id);
    }
}
