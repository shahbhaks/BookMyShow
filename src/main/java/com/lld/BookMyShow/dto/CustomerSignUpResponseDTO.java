package com.lld.BookMyShow.dto;


import lombok.Data;


import java.util.List;

@Data
public class CustomerSignUpResponseDTO {

    private Long id;
    private String name;
    private String email;
    private int responseCode;
    private String responseMessage;
   // private List<TicketResponseDTO> ticket;


}
