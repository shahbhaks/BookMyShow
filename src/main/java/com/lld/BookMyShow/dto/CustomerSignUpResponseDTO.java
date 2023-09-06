package com.lld.BookMyShow.dto;


import com.lld.BookMyShow.models.Ticket;
import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerSignUpResponseDTO {

    private Long id;
    private String name;
    private String email;
    private int responseCode;
    private String responseMessage;
    private List<Ticket> ticket;


}
