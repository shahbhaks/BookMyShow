package com.lld.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private MovieShow movieShow;

    @Enumerated(EnumType.ORDINAL)
    //@ElementCollection    //creates mapping table for screen to features
    //Dont need @ElementCollection coz its 1:1 mapping(every ShowSeatRepository have one ShowSeatStatus)
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    private Seat seat;

    private double price;
}
