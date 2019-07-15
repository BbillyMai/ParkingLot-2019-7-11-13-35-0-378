package com.thoughtworks.tdd.story1;

import com.thoughtworks.tdd.story1.Exception.NotProvideTicketException;
import com.thoughtworks.tdd.story1.Exception.UnrecognizedParkingTicketException;

import java.util.Arrays;
import java.util.List;

public abstract class Parker implements Parkable {

    private List<ParkingLot> parkingLots;

    public Parker(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public abstract Ticket park(Car car) throws Exception;

    @Override
    public Car fetch(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new NotProvideTicketException();
        }

        for (ParkingLot parkingLots : parkingLots) {
            if (parkingLots.containsTicket(ticket)) {
                Car car = parkingLots.fetch(ticket);
                if (car != null) {
                    return car;
                }
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    @Override
    public boolean isFull() {
        return parkingLots.stream().allMatch(x -> x.isFull());
    }

    @Override
    public boolean containsTicket(Ticket ticket) {
        return parkingLots.stream().anyMatch(x -> x.containsTicket(ticket));
    }
}
