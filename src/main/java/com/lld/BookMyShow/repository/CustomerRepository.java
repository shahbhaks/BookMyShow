package com.lld.BookMyShow.repository;

import com.lld.BookMyShow.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    Optional<Customer> findById(Long customerId); //optional-->used for npe(null pointer exception) might contains OR NOT contains/empty

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByEmailAndName(String email, String name);

    @Override
    Customer save(Customer customer);  //used for both create & update
}
