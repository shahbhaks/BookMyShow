package com.lld.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToOne
    private MovieShow movieShow; //1 show have many tickets

    @OneToMany
    private List<Payment> payments;

    @ManyToOne
    private Customer customer; //1 show have many users

    @ManyToMany
    private List<ShowSeat> showSeats;

    private Date bookedAt;

    private double amount;

}
/*
        (Ticket m : m ShowSeatRepository)
        Suppose, Ticket1 bought Seat1
                    then Ticket1 was cancelled
                Ticket2 bought Seat1
                    then Ticket2 was cancelled
                Ticket3 bought Seat1

               - Seat1 belongs to 3 tickets, 2 cancelled and 1 active (showSeat 1 : m ticket)
               -Ticket4 bought Seat2, Seat3, Seat4 (showSeat m : 1 ticket)-->1 ticket can have many showSeats


 */
