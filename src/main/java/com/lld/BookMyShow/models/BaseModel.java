package com.lld.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass  //marks this class as super class of every other class
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //makes sure id auto increments everytime
    private Long id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP) //temporal-->automatically updates with current time every time new row is created
    private Date createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP) //temporal-->automatically updates with current time every time new row is created
    private Date updatedAt;

}
