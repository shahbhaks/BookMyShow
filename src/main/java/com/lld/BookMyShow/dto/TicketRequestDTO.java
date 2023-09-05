package com.lld.BookMyShow.dto;

import lombok.Data;

import java.util.List;

@Data
public class TicketRequestDTO {
    private Long customerId;
    private Long movieShowId;
    private List<Long> seatIds;

}
