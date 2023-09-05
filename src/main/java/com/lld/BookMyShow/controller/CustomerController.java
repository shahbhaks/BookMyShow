package com.lld.BookMyShow.controller;

import com.lld.BookMyShow.dto.CustomerSignUpRequestDTO;
import com.lld.BookMyShow.dto.CustomerSignUpResponseDTO;
import com.lld.BookMyShow.models.Customer;
import com.lld.BookMyShow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerSignUpResponseDTO signUp(CustomerSignUpRequestDTO customerSignUpRequestDTO){
        //Create User
        Customer customer;
        CustomerSignUpResponseDTO responseDTO = new CustomerSignUpResponseDTO();
        try{
            customer = customerService.signUp(customerSignUpRequestDTO.getName(),
                    customerSignUpRequestDTO.getEmail(),customerSignUpRequestDTO.getPassword());

            // method that converts internal models into DTOs
            responseDTO.setId(customer.getId());
            responseDTO.setName(customer.getName());
            responseDTO.setEmail(customer.getEmail());
           // responseDTO.setTicket(customer.getTicket());
            responseDTO.setResponseCode(200);
            responseDTO.setResponseMessage("SUCCESS");

            return responseDTO;

        }catch (Exception e){
            responseDTO.setResponseCode(500);
            responseDTO.setResponseMessage("Internal Server Error");

            return responseDTO;
        }
    }
}
