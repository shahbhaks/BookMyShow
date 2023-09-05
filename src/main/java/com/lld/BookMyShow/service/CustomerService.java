package com.lld.BookMyShow.service;

import com.lld.BookMyShow.models.Customer;

public interface CustomerService {

    Customer login(String email, String password);

    Customer signUp(String name, String email, String password);
}
