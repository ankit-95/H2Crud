package com.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h2.entity.Customer;

public interface CustomerRepositroy extends JpaRepository<Customer, Long>{


}
