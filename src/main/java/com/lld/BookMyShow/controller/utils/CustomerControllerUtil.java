package com.lld.BookMyShow.controller.utils;

import com.lld.BookMyShow.dto.CustomerSignUpRequestDTO;
import com.lld.BookMyShow.dto.CustomerSignUpResponseDTO;
import com.lld.BookMyShow.models.Customer;

public class CustomerControllerUtil {
    public static void validateCustomerSignUPRequestDTO(CustomerSignUpRequestDTO userSignUpRequestDTO){
        //validation logic
        // if anything fails, throw an exception
    }



    public CustomerSignUpResponseDTO convertUserToUserResponseDTO(Customer customer) {
        CustomerSignUpResponseDTO responseDTO = new CustomerSignUpResponseDTO();
        responseDTO.setId(customer.getId());
        responseDTO.setEmail(customer.getEmail());
        responseDTO.setName(customer.getName());
        responseDTO.setTicket(customer.getTickets());
        return responseDTO;
    }

    public Customer convertUserDtoToUser(CustomerSignUpResponseDTO customerSignUpResponseDTO) {
        Customer customer = new Customer();
        customer.setId(customerSignUpResponseDTO.getId());
        customer.setEmail(customerSignUpResponseDTO.getEmail());
        customer.setName(customerSignUpResponseDTO.getName());
        customer.setTickets(customerSignUpResponseDTO.getTicket());
        return customer;
    }

}
