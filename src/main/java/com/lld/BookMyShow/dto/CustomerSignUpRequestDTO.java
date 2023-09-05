package com.lld.BookMyShow.dto;

import lombok.Data;

@Data //adds getter,setter,toString
public class CustomerSignUpRequestDTO {

    private String name;
    private String email;
    private String password;

}
