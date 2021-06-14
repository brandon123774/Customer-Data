package com.company.CustomerData.controller;

import com.company.CustomerData.dao.CustomerRepository;
import com.company.CustomerData.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //POST mapping to create a new customer

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer newCustomer)   {
        return customerRepository.save(newCustomer);
    }

    //GET to get all customers
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(@RequestParam (required = false) String level, String state)   {
        if(level != null)   {
            return customerRepository.findByLevel(level);
        } else if (state != null){
            return customerRepository.findByState(state);
        }
        return customerRepository.findAll();
    }

    //find customers by id
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id)   {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent())  {
            return null;
        }
        return customer.get();
    }

    //put to get update customer
    @PutMapping(value = "/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int id)    {
//        if(customer.getCustomerId() = null)    {
//            customer.setCustomerId(id);
//        }
        customerRepository.save(customer);
    }

    //delete customer record
    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable int id)    {
        customerRepository.deleteById(id);
    }

    //GET mapping for records by level

//    @GetMapping(value = "/{level}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Customer> getAllLevel (@RequestParam (required = false) String typeOfLevel) {
//        return customerRepository.findAll();
//    }

//    @GetMapping(value = "/level")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Customer> getAllLevel( String level) {
//        return customerRepository.findByLevel(level);
//    }

}
