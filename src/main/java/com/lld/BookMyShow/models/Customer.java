package com.lld.BookMyShow.models;

import com.lld.BookMyShow.dto.TicketResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Customer extends BaseModel{

    private String name;

    private String email;

    private String password;

    @OneToMany
    private List<Ticket> tickets;


}
