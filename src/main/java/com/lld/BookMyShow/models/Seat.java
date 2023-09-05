package com.lld.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    private int rowVal;

    private int colVal;

    private String seatNumber;

    @ManyToOne
    private SeatType seatType;  //many seats can have 1 seatType
}

//100 seats (Mapping)

//VIP seatType-->20 seats
//SILVER seatType--->50 seats
//GOLD seatType---->30 seats
