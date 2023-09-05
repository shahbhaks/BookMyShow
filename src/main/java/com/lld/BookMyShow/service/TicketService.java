package com.lld.BookMyShow.service;

import com.lld.BookMyShow.models.Ticket;

import java.util.List;

public interface TicketService {

    Ticket bookTicket(Long customerId, List<Long> showSeatIds, Long movieShowId);

    Ticket cancelTicket(Long ticketId);

    Ticket transferTicket(Long ticketId, Long fromCustomerId, Long toCustomerId);
}
