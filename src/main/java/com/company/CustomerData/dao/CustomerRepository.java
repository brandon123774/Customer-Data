package com.company.CustomerData.dao;

import com.company.CustomerData.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    List<Customer> findByLevel(String level);
    List<Customer> findByState(String state);
}
