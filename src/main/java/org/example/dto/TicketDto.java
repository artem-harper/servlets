package org.example.dto;

public class TicketDto {

    private final Long id;
    private final Long flightId;
    private final String seatNo;

    public TicketDto(Long id, Long flightId, String seatNo) {
        this.id = id;
        this.flightId = flightId;
        this.seatNo = seatNo;
    }

    public Long getId() {
        return id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
               "id=" + id +
               ", flightId=" + flightId +
               ", seatNo='" + seatNo + '\'' +
               '}';
    }
}
