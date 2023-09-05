package com.lld.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//Creating class NOT ENUM for SeatType coz diff city can have diff name for seattype, so each city can specify its own seattype
public class SeatType extends BaseModel{

    private String name;
}
