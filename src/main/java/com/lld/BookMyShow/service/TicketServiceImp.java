package com.lld.BookMyShow.service;

import com.lld.BookMyShow.exceptions.CustomerNotFoundException;
import com.lld.BookMyShow.exceptions.TicketNotFoundException;
import com.lld.BookMyShow.models.*;
import com.lld.BookMyShow.repository.CustomerRepository;
import com.lld.BookMyShow.repository.ShowSeatRepository;
import com.lld.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImp implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Ticket bookTicket(Long customerId, List<Long> showSeatIds, Long movieShowId) {
        return null;
    }

    @Override
    public Ticket cancelTicket(Long ticketId) {

        //fetch ticket
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);

        //1.if ticket not even present
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket for given id not found");

        }

        //2.if ticket present
        Ticket ticket = ticketOptional.get();
              //update bookingStatus "Cancelled" AS WELL AS update showSeatStatus "Available
        ticket.setBookingStatus(BookingStatus.CANCELLED);
                 //updating showSeats
        for(ShowSeat showSeat: ticket.getShowSeats()){
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(showSeat);
        }
        ticketRepository.save(ticket);


//        for(Payment p : ticket.getPayments()){
//            p.getRefNo();
//            //send a message to 3rd party with payment ref number for refund
//        }

        return ticket;
    }

    @Override
    public Ticket transferTicket(Long ticketId, Long fromCustomerId, Long toCustomerId) {
        //fetch ticket
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);

        //1.if ticket not even present
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket for given id not found");
        }

        //2.Find users
        Optional<Customer> fromCustomerOptional = customerRepository.findById(fromCustomerId);
        Optional<Customer> toCustomerOptional = customerRepository.findById(toCustomerId);

        //if either of its empty, throw exception
        if(fromCustomerOptional.isEmpty() || toCustomerOptional.isEmpty()){
            throw new CustomerNotFoundException("User details given for ticket transfer is not found");
        }

        //if found
        //Note: will need old user for audit or bookingHistory
        Ticket ticket = ticketOptional.get();

        //for old user--->getOldUser, remove from bookingHistory, Save changes in db
        Customer fromCustomer = fromCustomerOptional.get();
        List<Ticket> bookedTicketHistory = fromCustomer.getTickets();
        bookedTicketHistory.remove(ticket);
        customerRepository.save(fromCustomer);

        //for new user--->getNewUser, add in bookingHistory, Save changes in db
        Customer toCustomer = toCustomerOptional.get();
        bookedTicketHistory = toCustomer.getTickets();
        bookedTicketHistory.add(ticket);
        toCustomer = customerRepository.save(toCustomer);

        ticket.setCustomer(toCustomer);
        return ticketRepository.save(ticket);

    }
}
