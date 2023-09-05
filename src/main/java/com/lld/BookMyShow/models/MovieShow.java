package com.lld.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{

    @ManyToOne
    private Movie move;   //show : movie(1 movies belongs to many show)

    private Date startTime;

    private Date endTime;

    @OneToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection         //creates mapping table for show to features
    private List<Feature> features;

}
