package com.lld.BookMyShow.service;

import com.lld.BookMyShow.exceptions.CustomerAlreadyExistsException;
import com.lld.BookMyShow.exceptions.CustomerNotFoundException;
import com.lld.BookMyShow.exceptions.InvalidCredentialException;
import com.lld.BookMyShow.models.Customer;
import com.lld.BookMyShow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer login(String email, String password) {
        //find user

        Optional<Customer> customerOptional = customerRepository.findByEmail(email);
        //1.if user not found
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("User with given email doesn't exist : " + email);
        }

        //2.user found
        Customer customer = customerOptional.get();
        if(customer.getPassword().equals(password)){ //if user password matches with password u provided
            return customer;
        }
        else{
            throw new InvalidCredentialException("Credentials are Invalid");
        }

    }

    @Override
    public Customer signUp(String name, String email, String password) {
        //find user
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);

        //1.if user already present,throw exception
        if(customerOptional.isPresent()){
            throw new CustomerAlreadyExistsException("User with given email is already present :" + email);
        }

        //if not present, create user
        Customer newCustomer = new Customer();
        newCustomer.setPassword(password);
        newCustomer.setEmail(email);
        newCustomer.setName(name);


        return customerRepository.save(newCustomer);
    }
}
