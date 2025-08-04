package org.example.service;

import org.example.dao.TicketDao;
import org.example.dto.TicketDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    private final static TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService(){
    }

    public List<TicketDto> findTicketsByFlightId(Long flightId){
        return ticketDao.getTicketsByFlightId(flightId)
                .stream()
                .map(ticket -> new TicketDto(ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo())).collect(Collectors.toList());
    }

    public static TicketService getInstance(){
        return INSTANCE;
    }

}
